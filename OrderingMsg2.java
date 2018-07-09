

import java.util.Scanner;

public class OrderingMsg2 {
	public static void main(String[] args) {
		//数据主题，一组订单信息
		String[] names=new String[4];
		String[] disMegs=new String[4];
		int[] times=new int[4];
		String[] addresses=new String[4];
		int[] states=new int[4];
		double[] sumPrices=new double[4];
		//初始化2条订单信息
		names[0]="张晴";
		disMegs[0]="鱼香肉丝 1份";
		times[0]=12;
		addresses[0]="天成路209号";
		states[0]=0;
		sumPrices[0]=24.0;
		names[1]="张晴";
		disMegs[1]="红烧带鱼 2份";
		times[1]=12;
		addresses[1]="天成路209号";
		states[1]=1;
		sumPrices[1]=76.0;
		//数据主体：一组餐品信息
		String[] dishNames={"红烧带鱼","鱼香肉丝","时令蔬菜"};
		double[] prices={38.0,18.0,10.0};
		int[] praiseNums=new int[3];
		Scanner input=new Scanner(System.in);
		int num=-1;
		do{
			System.out.println("***************");
			System.out.println("1、我要订餐");
			System.out.println("2、查看餐带");
			System.out.println("3、删除订单");
			System.out.println("4、签收订单");
			System.out.println("5、我要点赞");
			System.out.println("6、退出系统");
			System.out.println("请选择");
			int choose=input.nextInt();
			boolean isAdd=false;
			switch(choose){
			case 1:
				//我要订餐
				System.out.println("******我要订餐*********");
				for(int i=0;i<names.length;i++){
					if(names[i]==null){
						isAdd=true;
						//餐品信息
						System.out.println("序号\t餐品名\t单价\t点赞数\t");
						for(int j=0;j<dishNames.length;j++){
							String price=prices[j]+"元";
							String praise=praiseNums[j]+"赞";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
						}
						//输入餐品序号和份数
						System.out.println("请选择所定餐品序号：");
						int chooseDish =input.nextInt();
						System.out.println("请输入所定份数：");
						int number =input.nextInt();
						String dishMeg=dishNames[chooseDish-1]+" "+number;
						//输入订餐人姓名
						System.out.println("请输入订餐人姓名");
						String name=input.next();
						//输入送餐时间
						System.out.println("请输入送餐时间（10-20之间的整数）");
						int time=input.nextInt();
						
						while(time<10||time>20){
							System.out.println("您的输入有误,请输入10-20之间的整数");
							time=input.nextInt();
						}
						//输入送餐地址
						System.out.println("请输入送餐地址");
						String address=input.next();
						
						//计算餐费
						double sumPrice=prices[chooseDish-1]*number;
						//送餐费，当达到50元时，免6元送餐费
						double deliCharge=sumPrice>50?0.0:6.0;
						
						//显示订餐信息
						System.out.println("订餐成功");
						System.out.println("您订的是："+dishMeg);
						System.out.println("订餐人："+name);
						System.out.println("送餐时间："+time+"点");
						System.out.println("送餐地址："+address);
						System.out.println("餐费："+sumPrice+",送餐费"+deliCharge+"元");
						System.out.println("总金额："+(sumPrice+deliCharge)+"元");
						
						//保存数据
						names[i]=name;
						disMegs[i]=dishMeg;
						times[i]=time;
						addresses[i]=address;
						sumPrices[i]=sumPrice+deliCharge;
						break;
					}
					
				}
				if(isAdd){
					System.out.println("对不起，您的餐带已满，无法订餐");
				}
				break;
			case 2:
				//查看餐袋人
				System.out.println("******查看餐袋");
				System.out.println("序号\t订餐人\t所定餐品信息\t订餐时间\t送餐地址\t\t总金额\t订单状态\t");
				for(int i=0;i<names.length;i++){
					if(names[i]!=null){
						String time=times[i]+"点";
						
						String sumPrice=sumPrices[i]+"元";
						String state=states[i]==0?"已预订":"已完成";
						System.out.println((i+1)+"\t"+names[i]+"\t"+disMegs[i]+"\t"+time+"\t"+addresses[i]+"\t"+sumPrice+"\t"+state);
						
					}
				}
				break;
			case 3:
				//删除订单
				System.out.println("请输入要删除的订单");
				int id=input.nextInt();
				boolean find=false;
				for(int i=0;i<names.length;i++){
					if(names[i]!=null&&states[i]==0&&id==i+1){
						find=true;
						for(int j=i;j<names.length-1;j++){
							names[j]=names[j+1];
							disMegs[j]=disMegs[j+1];
							times[j]=times[j+1];
							addresses[j]=addresses[j+1];
							sumPrices[j]=sumPrices[j+1];
							states[j]=states[j+1];
						}
						names[names.length-1]=null;
						disMegs[names.length-1]=null;
						times[names.length-1]=0;
						addresses[names.length-1]=null;
						sumPrices[names.length-1]=0;
						states[names.length-1]=0;
					}else if(names[i]!=null&&states[i]==1&&id==i+1){
						find=true;
						System.out.println("该订单已经签收，无法删除");
					}
				}
				if(find=false){
					System.out.println("此订单不存在");
				}
				break;
			case 4:
				//签收订单
				System.out.println("请输入要签收的订单序号：");
				int signOrderId=input.nextInt();
				boolean isFind=false;
				for(int i =0;i<names.length;i++){
					if(names[i]!=null&&states[i]==1&&signOrderId==i+1){
						System.out.println("对不起，您选择的订单已经完成签收，不能再次签收");
						isFind=true;
						break;
					}else if(names[i]!=null&&states[i]==0&&signOrderId==i+1){
						states[i]=1;
						System.out.println("订单签收完成");
						isFind=true;
					}
				}
				if(isFind==false){
					System.out.println("此订单不存在");
				}
				
				break;
			case 5:
				//我要点赞
				
						//餐品信息
				System.out.println("序号\t餐品名\t单价\t点赞数\t");
				for(int j=0;j<dishNames.length;j++){
					String price=prices[j]+"元";
					String praise=praiseNums[j]+"赞";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t"+price+"\t"+praise);
				}
				System.out.println("请输入要点赞的订单序号：");
				int zanId=input.nextInt();
				boolean zanFind=false;
				for(int i =0;i<dishNames.length;i++){
					if(dishNames[i]!=null&&zanId==i+1){
						zanFind=true;
						praiseNums[i]++;
						System.out.println("点赞成功");
						break;
					}
				}
				if(zanFind==false){
					System.out.println("此订单不存在");
				}
				break;
			case 6:
				//退出系统
				break;
			default:
				//退出系统
				break;
			
			}
			if(choose<1||choose>5){
				break;
			}else{
			//提示输入0返回
			System.out.println("请输入0返回");
			num=input.nextInt();
			}
		}while(num==0);
		System.out.println("谢谢使用，欢迎下次光临");
	}
}
