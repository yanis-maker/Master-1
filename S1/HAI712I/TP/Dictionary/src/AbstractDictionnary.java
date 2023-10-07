
public abstract class AbstractDictionnary implements IDictionary{
	
	protected int size;
	protected Object[] keys;
	protected Object[] values; 
	
	
	public boolean containsKey(Object key) {
		return this.indexOf(key)==-1;
		
	}
	
	public Object get(Object key) {
		return this.values[this.indexOf(key)];
		
	}
	
	public IDictionary put(Object key,Object value) {
		IDictionary new_dico;
		int new_index=newIndexOf(key);
		
		this.keys[new_index]=key;
		this.values[new_index]=value;
		return this;
		
	}
	
	public boolean isEmpty() {
		return size==0;
		
	} 	
	
	public int getSize() {
		return this.size;
		
	}
	
	protected abstract int indexOf(Object key); 
	protected abstract int newIndexOf(Object key);
}
