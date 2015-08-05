class Algo{
	public static void main(String [] args){
		try{int i=0;
			while(true){
				System.out.println(((i*(1-(i/100)%2)))%100	+ (100-(i%100))*((i/100)%2));
				Thread.sleep(30);
				i++;
			}
		}
		catch(Exception e){}
	}
}