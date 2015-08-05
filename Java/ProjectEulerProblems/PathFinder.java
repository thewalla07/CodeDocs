import java.util.*;
class T{}
class PathFinder{
	public static void main(String [] args){
		//
	}

	static boolean isLooped(LinkedList<T> list){
		int i = 0;
		int j = 1;
		T p1 = list.get(i);
		T p2 = list.get(j);
		while(p2!=list.getLast()){
			if(p1.equals(p2))return true;
			p1 = list.get(i+1);
			p2 = list.get(j+1);
			if(p2!=list.getLast()) p2 = list.get(j+2);
			i++; 
			j+=2;
		}
		return false;
	}
}