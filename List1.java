package test3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
//测试List接口中的ArratyList,LinkedList,Vector,Stack类的时间复杂度
public class List1 {
	public static void main(String[] args)
	{
		List1 t=new List1();
 		t.list(list1);
		t.list(list2);
		t.list(list3);
		t.list(list4);
	}
	static ArrayList<Integer> list1=new ArrayList<Integer>();
	static LinkedList<Integer> list2=new LinkedList<Integer>();
	static Vector<Integer> list3=new Vector<Integer>();	
	static Stack<Integer> list4=new Stack<Integer>();
	
	//返回测试的类名称
	//a instanceof b，表示a是否是b的子类,其中b可以是类,也可以是接口 
	private static String getName(List<Integer> list) {
        String name = "";
        if(list instanceof ArrayList){
            name = "ArrayList";
        }
        else if(list instanceof LinkedList){
            name = "LinkedList";
        }
        else if(list instanceof Stack) {
            name = "Stack";      	//Stack继承于Vector，两者不能互换位置，若list为Stack类型则认为与Vector匹配
        }
        else if(list instanceof Vector){
            name = "Vector";
        }
        
       
          
        return name;
    }
	
	//设置规模为一万到一百万，分别测试插入，查找，删除数据所用时间并打印输出
	public void list(List<Integer> list)
	{	
		for(int i=1000;i<1000000;i=i+200000)
		{
			long startTime=System.currentTimeMillis();
			for(int j=0;j<i;j++)
			{
				list.add(0,j);				//插入数据
			}	
			long endTime=System.currentTimeMillis();
			System.out.println("插入"+i+"个数据"+getName(list)+"需要的时间为："+(endTime-startTime));
			
			long startTime2=System.currentTimeMillis();
			for(int k=0;k<i;k++)
			{
				list.get(k);			//查找数据
			}
			long endTime2=System.currentTimeMillis();
			System.out.println("长度为"+i+"时"+getName(list)+"的查找时间为："+(endTime2-startTime2));
			
			long startTime3=System.currentTimeMillis();
			list.removeAll(list);				//删除数据
			long endTime3=System.currentTimeMillis();
			System.out.println("长度为"+i+"时"+getName(list)+"的删除时间为："+(endTime3-startTime3)+"\n");
		}
		
	}
}
