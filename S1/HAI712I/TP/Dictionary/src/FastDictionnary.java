
public class FastDictionnary extends AbstractDictionnary{

	@Override
	protected int indexOf(Object key) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int newIndexOf(Object key) {
		if(this.mustgrow()) {
			this.grow();
		}
		return 0;
	}
	
	public int size() {
		int cpt=0;
		for(int i=0;i<this.size;i++) {
			if(this.keys[i]!=null) {
				cpt++;
			}
		}
		return cpt;
	}
	
	public boolean mustgrow() {
		return this.size()>this.size*0.75;
	}
	
	public void grow() {
		Object[] newkeys=new Object[this.size+5];
		Object[] newvalues=new Object[this.size+5];
		
		for(int i=0;i<this.size();i++) {
			newkeys[i]=keys[i];
			newvalues[i]=values[i];
		}
		
		this.keys=newkeys;
		this.values=newvalues;
		this.size+=5;
		
	}
	
	
	
	
	
	
	

}
