package test3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;
//����List�ӿ��е�ArratyList,LinkedList,Vector,Stack���ʱ�临�Ӷ�
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
	
	//���ز��Ե�������
	//a instanceof b����ʾa�Ƿ���b������,����b��������,Ҳ�����ǽӿ� 
	private static String getName(List<Integer> list) {
        String name = "";
        if(list instanceof ArrayList){
            name = "ArrayList";
        }
        else if(list instanceof LinkedList){
            name = "LinkedList";
        }
        else if(list instanceof Stack) {
            name = "Stack";      	//Stack�̳���Vector�����߲��ܻ���λ�ã���listΪStack��������Ϊ��Vectorƥ��
        }
        else if(list instanceof Vector){
            name = "Vector";
        }
        
       
          
        return name;
    }
	
	//���ù�ģΪһ��һ���򣬷ֱ���Բ��룬���ң�ɾ����������ʱ�䲢��ӡ���
	public void list(List<Integer> list)
	{	
		for(int i=1000;i<1000000;i=i+200000)
		{
			long startTime=System.currentTimeMillis();
			for(int j=0;j<i;j++)
			{
				list.add(0,j);				//��������
			}	
			long endTime=System.currentTimeMillis();
			System.out.println("����"+i+"������"+getName(list)+"��Ҫ��ʱ��Ϊ��"+(endTime-startTime));
			
			long startTime2=System.currentTimeMillis();
			for(int k=0;k<i;k++)
			{
				list.get(k);			//��������
			}
			long endTime2=System.currentTimeMillis();
			System.out.println("����Ϊ"+i+"ʱ"+getName(list)+"�Ĳ���ʱ��Ϊ��"+(endTime2-startTime2));
			
			long startTime3=System.currentTimeMillis();
			list.removeAll(list);				//ɾ������
			long endTime3=System.currentTimeMillis();
			System.out.println("����Ϊ"+i+"ʱ"+getName(list)+"��ɾ��ʱ��Ϊ��"+(endTime3-startTime3)+"\n");
		}
		
	}
}
