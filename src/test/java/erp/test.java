package erp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class test {
//f7b36648-fa1a-4de2-ad38-191d5a1999e4
//alibaba.client_id=3110202
//#1688appsecret
//alibaba.appSecret=VWZukaBLE3	
	
	
	  /**读取csv文件
     * @param filePath 文件路径
     * @param headers csv列头
     * @return CSVRecord 列表
     * @throws IOException **/
    public static List<CSVRecord> readCSV(String filePath,String[] headers) throws IOException{
    	//把file转成mutilfile
    	File file = new File(filePath);
    	FileInputStream input = new FileInputStream(file);
    	MultipartFile multipartFile = new MockMultipartFile("file",
    	file.getName(), "text/plain", input);
    	
    	InputStream is=multipartFile.getInputStream();
    	
        //创建CSVFormat
        CSVFormat formator = CSVFormat.DEFAULT.withHeader(headers);
//        FileReader fileReader=new FileReader(filePath);
        
        DataInputStream in = new DataInputStream(is);
        BufferedReader br= new BufferedReader(new InputStreamReader(in,"GBK"));//这里如果csv文件编码格式是utf-8,
        
        //创建CSVParser对象
        CSVParser parser=new CSVParser(br,formator);
        List<CSVRecord> records=parser.getRecords();
        parser.close();
        br.close();
        in.close();
        return records;    
    }
  //CSV文件分隔符
    private final static String NEW_LINE_SEPARATOR="\n";
    /**写入csv文件
         * @param headers 列头
          * @param data 数据内容
          * @param filePath 创建的csv文件路径
          * @throws IOException **/
         public static void writeCsv(String[] headers,List<String[]> data,String filePath) throws IOException{
        	
        	 //初始化csvformat
             CSVFormat formator = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
            //创建FileWriter对象
             DataOutputStream in = new DataOutputStream(new FileOutputStream(new File(filePath)));
             BufferedWriter br= new BufferedWriter(new OutputStreamWriter(in,"GBK"));//这里如果csv文件编码格式是utf-8,
//            FileWriter fileWriter=new FileWriter(filePath);
            //创建CSVPrinter对象
            CSVPrinter printer=new CSVPrinter(br,formator);
            //写入列头数据
            printer.printRecord(headers);
            if(null!=data){
                //循环写入数据
                for(String[] lineData:data){
                   printer.printRecord(lineData);
                    
                }
           }
            
            System.out.println("CSV文件创建成功,文件路径:"+filePath);
            
            printer.close();
            br.close();
            in.close();
            
            
      }
    
public static void main(String[] args) throws IOException {
		

	
	
	
	
	
		String[] headers=new String[] {"订单编号","买家会员名","买家支付宝账号","支付单号","支付详情","买家应付货款","买家应付邮费","买家支付积分","总金额","返点积分","买家实际支付金额","买家实际支付积分","订单状态","买家留言","收货人姓名","收货地址","运送方式","联系电话","联系手机","订单创建时间","订单付款时间","宝贝标题","宝贝种类","物流单号","物流公司","订单备注","宝贝总数量","店铺Id","店铺名称","订单关闭原因","卖家服务费","买家服务费","发票抬头","是否手机订单","分阶段订单信息","特权订金订单id","是否上传合同照片","是否上传小票","是否代付","定金排名","修改后的sku","修改后的收货地址","异常信息","天猫卡券抵扣","集分宝抵扣","是否是O2O交易","新零售交易类型","新零售导购门店名称","新零售导购门店id","新零售发货门店名称","新零售发货门店id","退款金额","预约门店","确认收货时间","打款商家金额","含应开票给个人的个人红包"};
		String cvsPath="C:\\Users\\lenovo\\Desktop\\erp文档\\ExportOrderList201809011818.csv";
		try {
			List<CSVRecord> records=readCSV(cvsPath,headers);
			int size=records.size();
			for(int i=1;i<size;i++) {
				System.out.println(records.get(i).get("订单编号"));
				System.out.println(records.get(i).get("买家会员名"));
				System.out.println(records.get(i).get("买家支付宝账号"));
				System.out.println(records.get(i).get("支付单号"));
				System.out.println(records.get(i).get("支付详情"));
				System.out.println(records.get(i).get("买家应付货款"));
				System.out.println(records.get(i).get("买家应付邮费"));
				System.out.println(records.get(i).get("总金额"));
				System.out.println(records.get(i).get("买家实际支付金额"));
				System.out.println(records.get(i).get("订单状态"));
				System.out.println(records.get(i).get("买家留言"));
				System.out.println(records.get(i).get("收货人姓名"));
				System.out.println(records.get(i).get("收货地址"));
				System.out.println(records.get(i).get("运送方式"));
				System.out.println(records.get(i).get("联系电话"));
				System.out.println(records.get(i).get("联系手机"));
				System.out.println(records.get(i).get("订单创建时间"));
				System.out.println(records.get(i).get("订单付款时间"));
				System.out.println(records.get(i).get("宝贝标题"));
				System.out.println(records.get(i).get("物流单号"));
				System.out.println(records.get(i).get("物流公司"));
				System.out.println(records.get(i).get("订单备注"));
				System.out.println(records.get(i).get("宝贝总数量"));
				System.out.println(records.get(i).get("店铺Id"));
				System.out.println(records.get(i).get("店铺名称"));
				System.out.println(records.get(i).get("订单关闭原因"));
				System.out.println(records.get(i).get("是否手机订单"));
				System.out.println(records.get(i).get("订单关闭原因"));
				System.out.println(records.get(i).get("异常信息"));
				System.out.println(records.get(i).get("新零售交易类型"));
				System.out.println(records.get(i).get("退款金额"));
				System.out.println(records.get(i).get("确认收货时间"));
				System.out.println(records.get(i).get("打款商家金额"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
//		String[] headers=new String[] {"name","age","sex"};
//		List<String[]> data=new ArrayList<String[]>();
//		data.add(new String[] {"tom","15","阿拉山口到家了卡数据库第六届奥斯卡的"});
//		data.add(new String[] {"tom","15","nan"});
//		data.add(new String[] {"tom","15","阿萨德群文件尔康了几千万开了家"});
//		data.add(new String[] {"tom","15","nan"});
//		String csvPath="C:\\Users\\lenovo\\Desktop\\erp文档\\1.csv";
//		writeCsv(headers,data,csvPath);
		
	}
}
