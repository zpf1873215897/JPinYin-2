import java.io.File;

public class JPinYinDemo {
    public static JPinYin jPinYin = null;

    public static void main(String[] args) {
        //创建实例，需指定自带词典数据所在目录
        //自带词典文件加载顺序，同名词的发音，后面加载的词典会覆盖前面的。
        // surnames 多音字姓名
        // words_* 内置词典，顺序0到n
        // users_* 用户自定义词典，顺序0到n

        jPinYin = new JPinYin("./data");

        //如果需要加载指定的自定义词典文件，使用此方法加载，格式参考自带词典的 users_0
        jPinYin.loadDictsFromFile(new File("自定义词典文件路径"),false);

        //------------------------------------------------------------------------------------

        //转换句子成拼音
        System.out.println(jPinYin.convertSentence("两只黄鹂鸣翠柳，一行白鹭上青天！",JPinYin.TONE_UNICODE));
        //输出  liǎngzhīhuánglímíngcuìliǔ,yīhángbáilùshàngqīngtiān!

        //转换成可用于链接的拼音，自动去掉非汉字字符
        System.out.println(jPinYin.convertLink("两只黄鹂鸣翠柳，一行白鹭上青天！"));
        //输出 liang-zhi-huang-li-ming-cui-liu-yi-hang-bai-lu-shang-qing-tian

        //转换成可用于链接的拼音，自动去掉非汉字字符，可指定分隔符、只有首字符、首字母大写
        //只保留首字母，短线分隔
        System.out.println(jPinYin.convertLink("两只黄鹂鸣翠柳，一行白鹭上青天！","-",true,false));
        //输出 l-z-h-l-m-c-l-y-h-b-l-s-q-t

        //首字母大写，短线分隔
        System.out.println(jPinYin.convertLink("两只黄鹂鸣翠柳，一行白鹭上青天！","-",false,true));
        //输出 Liang-Zhi-Huang-Li-Ming-Cui-Liu-Yi-Hang-Bai-Lu-Shang-Qing-Tian

        //转换姓名
        System.out.println(jPinYin.convertName("单田芳",JPinYin.TONE_UNICODE));
        //输出 ShànTiánFāng


        //查字的拼音
        for(String pinyin: jPinYin.convertChar('长',JPinYin.TONE_UNICODE)) {
            System.out.print(pinyin+" ");
        }
        System.out.println();
        //输出 cháng zhǎng

        //------------------------------------------------------------------------------------

        //转换成拼音字符串，可指定音调类型、分隔符，中文符号自动转换为英文符号。

        //转换成拼音，Unicode声调, 需要UTF-8字符集
        System.out.println(jPinYin.convert("两只黄鹂鸣翠柳，一行白鹭上青天！",JPinYin.TONE_UNICODE,""));
        //输出 liǎngzhīhuánglímíngcuìliǔ,yīhángbáilùshàngqīngtiān!

        //转换成拼音，数字声调
        System.out.println(jPinYin.convert("两只黄鹂鸣翠柳，一行白鹭上青天！",JPinYin.TONE_NUMBER,""));
        //输出 liang3zhi1huang2li2ming2cui4liu3,yi1hang2bai2lu4shang4qing1tian1!

        //转换成拼音，无声调
        System.out.println(jPinYin.convert("两只黄鹂鸣翠柳，一行白鹭上青天！",JPinYin.TONE_NONE,""));
        //输出 liangzhihuanglimingcuiliu,yihangbailushangqingtian!

        //转换成拼音，指定分隔符
        System.out.println(jPinYin.convert("两只黄鹂鸣翠柳，一行白鹭上青天！",JPinYin.TONE_NUMBER,"-"));
        //输出 liang3-zhi1-huang2-li2-ming2-cui4-liu3-,-yi1-hang2-bai2-lu4-shang4-qing1-tian1-!

        //指定分隔符
        System.out.println(jPinYin.convert("两只黄鹂鸣翠柳，一行白鹭上青天！",JPinYin.TONE_UNICODE," "));
        //输出 liǎng zhī huáng lí míng cuì liǔ , yī háng bái lù shàng qīng tiān !


    }

}