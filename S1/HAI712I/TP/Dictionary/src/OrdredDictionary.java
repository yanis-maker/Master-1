
public class OrdredDictionary extends AbstractDictionnary {
	
	

	public OrdredDictionary() {
		this.size=0;
		this.keys=new Object[0];
		this.values=new Object[0];
	}
	protected int indexOf(Object key) {
		int i=0;
		int indice = 0;
		boolean found=false;
		while(i<this.size && !found) {
			if(this.keys[i].equals(key)) {
				found=true;
				indice=i;
			}
			i++;
		}
		return i==size && found==false ? -1 : indice;
	}
	
	protected int newIndexOf(Object key) {
		
		Object[] new_keys=new Object[this.size+1];
		Object[] new_values=new Object[this.size+1];
		for(int i=0;i<this.size;i++) {
			new_keys[i]=this.keys[i];
			new_values[i]=this.values[i];
		}
		this.keys=new_keys;
		this.values=new_values;
		this.size+=1;
		return this.size-1;
	}
	


}
