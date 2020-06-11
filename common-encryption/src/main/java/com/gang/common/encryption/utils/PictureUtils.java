package com.gang.common.encryption.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

/**
 * @Classname PicUtils
 * @Description 图片压缩 , 图片加密
 * @Date 2020/6/10 23:18
 * @Created by zengzg
 */
public class PictureUtils {


    /**
     * 判断文件夹是否存在
     */
    public void havefiles(String url) {
        System.out.println(url);
        File dir = new File(url);
        // 判断文件夹是否存在
        if (dir.exists()) {
            if (dir.isDirectory()) {
                System.out.println("dir exists");
            } else {
                System.out.println("the same name file exists, can not create dir");
            }
        } else {
            System.out.println("dir not exists, create it ...");
            dir.mkdir();
        }

    }

    /**
     * 判断多级路径是否存在，不存在就创建
     *
     * @param filePath 支持带文件名的Path：如：D:\news\2014\12\abc.text，和不带文件名的Path：如：D:\news\2014\12
     */
    public static void isExistDir(String filePath) {
        String paths[] = {""};
        //切割路径
        try {
            String tempPath = new File(filePath).getCanonicalPath();//File对象转换为标准路径并进行切割，有两种windows和linux
            paths = tempPath.split("\\\\");//windows
            if (paths.length == 1) {
                paths = tempPath.split("/");
            }//linux
        } catch (IOException e) {
            System.out.println("切割路径错误");
            e.printStackTrace();
        }
        //判断是否有后缀
        boolean hasType = false;
        if (paths.length > 0) {
            String tempPath = paths[paths.length - 1];
            if (tempPath.length() > 0) {
                if (tempPath.indexOf(".") > 0) {
                    hasType = true;
                }
            }
        }
        //创建文件夹
        String dir = paths[0];
        for (int i = 0; i < paths.length - (hasType ? 2 : 1); i++) {// 注意此处循环的长度，有后缀的就是文件路径，没有则文件夹路径
            try {
                dir = dir + "/" + paths[i + 1];//采用linux下的标准写法进行拼接，由于windows可以识别这样的路径，所以这里采用警容的写法
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                    System.out.println("成功创建目录：" + dirFile.getCanonicalFile());
                }
            } catch (Exception e) {
                System.err.println("文件夹创建发生异常");
                e.printStackTrace();
            }
        }
    }

    /**
     * *
     * 按指定的比例缩放图片
     *
     * @param sourceImagePath 源地址
     * @param destinationPath 改变大小后图片的地址
     * @param scale           缩放比例，如1.2
     */
    public static void scaleImage(String sourceImagePath,
                                  String destinationPath, double scale, String format) {

        File file = new File(sourceImagePath);
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();

            width = parseDoubleToInt(width * scale);
            height = parseDoubleToInt(height * scale);

            Image image = bufferedImage.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            BufferedImage outputImage = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = outputImage.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            ImageIO.write(outputImage, format, new File(destinationPath));
        } catch (IOException e) {
            System.out.println("scaleImage方法压缩图片时出错了");
            e.printStackTrace();
        }
    }

    /**
     * *
     * 将图片缩放到指定的高度或者宽度
     *
     * @param sourceImagePath 图片源地址
     * @param destinationPath 压缩完图片的地址
     * @param width           缩放后的宽度
     * @param height          缩放后的高度
     * @param auto            是否自动保持图片的原高宽比例
     * @param format          图图片格式 例如 jpg
     */
    public static void scaleImageWithParams(String sourceImagePath,
                                            String destinationPath, int width, int height, boolean auto,
                                            String format) {

        try {
            File file = new File(sourceImagePath);
            BufferedImage bufferedImage = null;
            bufferedImage = ImageIO.read(file);
            if (auto) {
                ArrayList<Integer> paramsArrayList = getAutoWidthAndHeight(bufferedImage, width, height);
                width = paramsArrayList.get(0);
                height = paramsArrayList.get(1);
                System.out.println("自动调整比例，width=" + width + " height=" + height);
            }

            Image image = bufferedImage.getScaledInstance(width, height,
                    Image.SCALE_DEFAULT);
            BufferedImage outputImage = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = outputImage.getGraphics();
            graphics.drawImage(image, 0, 0, null);
            graphics.dispose();
            ImageIO.write(outputImage, format, new File(destinationPath));
        } catch (Exception e) {
            System.out.println("scaleImageWithParams方法压缩图片时出错了");
            e.printStackTrace();
        }

    }

    /**
     * *
     *
     * @param bufferedImage 要缩放的图片对象
     * @param width_scale   要缩放到的宽度
     * @param height_scale  要缩放到的高度
     * @return 一个集合，第一个元素为宽度，第二个元素为高度
     */
    private static ArrayList<Integer> getAutoWidthAndHeight(BufferedImage bufferedImage, int width_scale,
                                                            int height_scale) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        double scale_w = getDot2Decimal(width_scale, width);

        System.out.println("getAutoWidthAndHeight width=" + width + "scale_w=" + scale_w);
        double scale_h = getDot2Decimal(height_scale, height);
        if (scale_w < scale_h) {
            arrayList.add(parseDoubleToInt(scale_w * width));
            arrayList.add(parseDoubleToInt(scale_w * height));
        } else {
            arrayList.add(parseDoubleToInt(scale_h * width));
            arrayList.add(parseDoubleToInt(scale_h * height));
        }
        return arrayList;

    }

    /**
     * *
     * 返回两个数a/b的小数点后三位的表示
     *
     * @param a
     * @param b
     * @return
     */
    public static double getDot2Decimal(int a, int b) {

        BigDecimal bigDecimal_1 = new BigDecimal(a);
        BigDecimal bigDecimal_2 = new BigDecimal(b);
        BigDecimal bigDecimal_result = bigDecimal_1.divide(bigDecimal_2, new MathContext(4));
        Double double1 = new Double(bigDecimal_result.toString());
        System.out.println("相除后的double为：" + double1);
        return double1;
    }

    /**
     * 将double类型的数据转换为int，四舍五入原则
     *
     * @param sourceDouble
     * @return
     */
    private static int parseDoubleToInt(double sourceDouble) {
        int result = 0;
        result = (int) sourceDouble;
        return result;
    }
}
