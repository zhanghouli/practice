package com.zhl.practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2018-08-12 16:10
 **/
public class GuiUtil {
    private JFrame frame;
    // 需要验证的列名
    private JTextField validationInput;
    private JLabel validationName;
    // 请选择需要对比的excel文件
    private JLabel lb_idTips;
    // 请选择作为参照的excel文件
    private JLabel lb_birth1;
    // 默认输出文件位置：f:/files/
    private JLabel lb_birth2;
    // 请输入需要保存的文件名：默认为需要对比文件的名称
    private JLabel lb_sex1;



    /**
     * Launch the application.
     */
    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuiUtil window = new GuiUtil();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    *//**
     * Create the application.
     *//*
    public GuiUtil() {
        initialize();
    }

    *//**
     * Initialize the contents of the frame.
     *//*
    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("excel数据对比工具");
        frame.setBounds(100, 100, 571, 405);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //窗口居中
        Toolkit tk=frame.getToolkit();
        Dimension dm=tk.getScreenSize();
        frame.setLocation((int)(dm.getWidth()-frame.getWidth())/2, (int)(dm.getHeight()-frame.getHeight())/2);

        JLabel lb_idNumber = new JLabel("身份证号码：");
        lb_idNumber.setForeground(Color.WHITE);
        lb_idNumber.setFont(new Font("宋体", Font.BOLD, 20));
        lb_idNumber.setBounds(91, 49, 126, 18);
        frame.getContentPane().add(lb_idNumber);

        validationInput = new JTextField();
        validationInput.setBounds(236, 42, 223, 33);
        frame.getContentPane().add(validationInput);
        validationInput.setColumns(10);


        JButton contract = new JButton("开始对比");
        contract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(rekonInput()){
                    if(rekonLastNumber()){
                        lb_idTips.setText(null);
                        lb_birth2.setText(getbirthDay());

                    }
                    else{
                        lb_idTips.setText("身份证号码有误");
                        lb_birth2.setText(null);
                    }
                }
            }
        });
        contract.setBounds(137, 300, 113, 27);
        frame.getContentPane().add(contract);

        lb_idTips = new JLabel("");
        lb_idTips.setFont(new Font("宋体", Font.BOLD, 17));
        lb_idTips.setForeground(Color.RED);
        lb_idTips.setBounds(236, 76, 240, 24);
        frame.getContentPane().add(lb_idTips);

        lb_birth1 = new JLabel("出生日期：");
        lb_birth1.setForeground(Color.WHITE);
        lb_birth1.setFont(new Font("宋体", Font.BOLD, 20));
        lb_birth1.setBounds(112, 112, 113, 18);
        frame.getContentPane().add(lb_birth1);

        lb_birth2 = new JLabel("");
        lb_birth2.setForeground(Color.WHITE);
        lb_birth2.setFont(new Font("宋体", Font.BOLD, 18));
        lb_birth2.setBounds(236, 112, 223, 18);
        frame.getContentPane().add(lb_birth2);

        lb_sex1 = new JLabel("性    别：");
        lb_sex1.setForeground(Color.WHITE);
        lb_sex1.setFont(new Font("宋体", Font.BOLD, 20));
        lb_sex1.setBounds(110, 152, 113, 18);
        frame.getContentPane().add(lb_sex1);


        JButton bt_clear = new JButton("\u6E05\u7A7A");
        bt_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validationInput.setText(null);
                lb_birth2.setText(null);
            }
        });
        bt_clear.setBounds(316, 300, 113, 27);
        frame.getContentPane().add(bt_clear);

    }

    //判断身份证号码最后一位是否正确
    public boolean rekonLastNumber(){
        int sum=0;
        String lastNum="";
        for(int i=0;i<id_int.length;i++){
            sum+=id_int[i]*id_digit[i];
        }
        switch(sum%11){
            case 0:lastNum="1";break;
            case 1:lastNum="0";break;
            case 2:lastNum="X";break;
            case 3:lastNum="9";break;
            case 4:lastNum="8";break;
            case 5:lastNum="7";break;
            case 6:lastNum="6";break;
            case 7:lastNum="5";break;
            case 8:lastNum="4";break;
            case 9:lastNum="3";break;
            case 10:lastNum="2";break;
        }
        if(lastNum.equalsIgnoreCase(id_String_18))
            return true;
        else return false;
    }

    //输入判断
    public boolean rekonInput(){
        String id=tf_idInput.getText();
        if(id.length()!=18){
            lb_idTips.setText("输入长度有误！");
            lb_birth2.setText(null);
            lb_age2.setText(null);
            lb_sex2.setText(null);
            lb_adress2.setText(null);
            return false;
        }
        else{
            String[] id_String=id.split("");//将输入的身份证号转为长度为18的字符串数组
            for(int i=0;i<id_String.length;i++){
                try{
                    if(i<17){
                        id_int[i]=Integer.parseInt(id_String[i]);
                    }
                    else{
                        if(id_String[i].equalsIgnoreCase("X")){
                            id_String_18=id_String[i].toUpperCase();
                        }
                        else{
                            id_int_18=Integer.parseInt(id_String[i]);
                            id_String_18=id_String[i].toUpperCase();
                        }
                    }

                }
                catch(NumberFormatException e1){
                    lb_idTips.setText("请输入正确的身份证号码！");
                    return false;
                }
            }
            return true;
        }
    }

    //获取出生日期
    public String getbirthDay(){
        String date=tf_idInput.getText().substring(6, 14);
        String year=date.substring(0, 4);
        String month=date.substring(4, 6);
        String day=date.substring(6, 8);
        return year+"年"+month+"月"+day+"日";
    }
    //获取年龄
    public int getAge(){
        Calendar c=Calendar.getInstance();
        int birth_Year=Integer.parseInt(tf_idInput.getText().substring(6, 10));
        return c.get(Calendar.YEAR)-birth_Year;
    }
    //获取性别
    public String getSex(){
        int sex=Integer.parseInt(tf_idInput.getText().substring(16,17));
        if(sex%2==1) return "男";
        else return "女";
    }
    //爬虫：抓取ip138的查询结果
    String getIdLocation(){
        String result ="";
        try{
            URL url = new URL("http://qq.ip138.com/idsearch/index.asp?action=idcard&userid="+tf_idInput.getText());
            HttpURLConnection httpuc=(HttpURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(httpuc.getInputStream(),"gb2312")) ;
            String html_Content="";
            String content;
            while((content=br.readLine())!=null){
                html_Content+=content;
            }
            //利用正则表达式获取户籍信息
            String regex="\\u53D1 \\u8BC1 \u5730\\uFF1A</td><td class=\"tdc2\">([\u4e00-\u9fa5]*\\s*[\u4e00-\u9fa5]*\\s*[\u4e00-\u9fa5]*\\s*[\u4e00-\u9fa5]*\\s*)";
            Pattern pattern=Pattern.compile(regex);
            Matcher matcher=pattern.matcher(html_Content);
            if(matcher.find()){
                result=matcher.group(1);
            }
            else result="查询失败";
            br.close();
        }catch(Exception e){
            result="未联网状态下，无法查询发证地区！";
        }
        return result;
    }
*/

}
