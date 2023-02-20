package org.xiao.rain.test.aspose;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.Test;

import com.aspose.pdf.Document;
import com.aspose.pdf.ImageType;
import com.aspose.pdf.License;
import com.aspose.pdf.Page;
import com.aspose.pdf.PageCollection;
import com.aspose.pdf.PageSize;
import com.aspose.pdf.RenderingOptions;
import com.aspose.pdf.XImage;
import com.aspose.pdf.XImageCollection;
import com.aspose.pdf.devices.PngDevice;
import com.aspose.pdf.devices.Resolution;
import com.aspose.pdf.optimization.OptimizationOptions;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * Author: xiaojl
 * Date:2022-11-17 14:16
 */
public class Aspdf {
    
    public void crack() {

        //2、用流的方式
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream("license/license.xml");

            License license = new License();
            license.setLicense(is);
       
            
       
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }


    @Test
    public void extract() throws Exception{
        long total = System.currentTimeMillis();
        String dataDir = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "contract/";
        String filePath = dataDir + "20221020.pdf";
        Locale locale = new Locale("zh", "cn");
        Locale.setDefault(locale);
        Document pdfDocument = new Document(filePath);
        PageCollection pages = pdfDocument.getPages();
        for (int i = 0; i < pages.size(); i++) {
            long startTime = System.currentTimeMillis();
            XImageCollection images = pages.get_Item(i + 1).getResources().getImages();
            for (int j = 0; j < images.size(); j++) {
                XImage xImage = images.get_Item(j+1);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                xImage.save(baos, ImageType.getPng());
            }
            System.out.println("花费的时间:" +(System.currentTimeMillis() - startTime));
        }

        System.out.println("花费的时间:" + ( System.currentTimeMillis() - total));
    }
    @Test
    public void extract2() throws Exception{
        long total = System.currentTimeMillis();
        String dataDir = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "contract/";
        String filePath = dataDir + "20221020.pdf";
        Locale locale = new Locale("zh", "cn");
        Locale.setDefault(locale);
        Document pdfDocument = new Document(filePath);
        PageCollection pages = pdfDocument.getPages();
        
        long compress = System.currentTimeMillis();
        
        OptimizationOptions opt = new OptimizationOptions();
        opt.getImageCompressionOptions().setCompressImages(true);
        opt.getImageCompressionOptions().setImageQuality(10);
        opt.getImageCompressionOptions().setMaxResolution(150);
        opt.getImageCompressionOptions().setResizeImages(true);
        pdfDocument.optimizeResources(opt);
        
        try(FileOutputStream fos = new FileOutputStream(dataDir +"/compress.pdf")) {
            pdfDocument.save(fos);
        }

        System.out.println("压缩花费的时间:"+ ( System.currentTimeMillis() - compress));
        
        Set<Integer> ocrPages = new HashSet<>();
        ocrPages.add(1);
        ocrPages.add(5);
        for (Integer pageIndex : ocrPages) {
            long startTime = System.currentTimeMillis();
            XImageCollection images = pages.get_Item(pageIndex).getResources().getImages();
            for (int j = 0; j < images.size(); j++) {
                XImage xImage = images.get_Item(j+1);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                xImage.save(baos, ImageType.getPng());
                //List<byte[]> bytesList = pageIndexImageByteListMap.computeIfAbsent(pageIndex, key -> new ArrayList<>());
                //bytesList.add(baos.toByteArray());
            }
            System.out.println("花费的时间:" +(System.currentTimeMillis() - startTime));
        }

        System.out.println("花费的时间:" + ( System.currentTimeMillis() - total));
    }
    @Test
    public void extract5() throws Exception{
        long total = System.currentTimeMillis();
        String dataDir = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "contract/";
        String filePath = dataDir + "20221020.pdf";
        Locale locale = new Locale("zh", "cn");
        Locale.setDefault(locale);
        Document pdfDocument = new Document(filePath);
        PageCollection pages = pdfDocument.getPages();
        
        Set<Integer> ocrPages = new HashSet<>();
        ocrPages.add(1);
        ocrPages.add(5);

        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (Integer pageIndex : ocrPages) {
                long startTime = System.currentTimeMillis();
                XImageCollection images = pages.get_Item(pageIndex).getResources().getImages();
                for (int j = 0; j < images.size(); j++) {
                    XImage xImage = images.get_Item(j+1);
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    xImage.save(baos, ImageType.getPng());
                    //String filepath = dataDir +"/image_" + (++index) +".png";
                    //try(FileOutputStream fos = new FileOutputStream(filepath)) {
                    //    xImage.save(fos, ImageType.getPng());
                    //} 
                    //List<byte[]> bytesList = pageIndexImageByteListMap.computeIfAbsent(pageIndex, key -> new ArrayList<>());
                    //bytesList.add(baos.toByteArray());
                }
                System.out.println("花费的时间:" +(System.currentTimeMillis() - startTime));
            }
            
        }
        

        System.out.println("花费的时间:" + ( System.currentTimeMillis() - total)/10);
    }
    @Test
    public void extract3() throws Exception{
        long total = System.currentTimeMillis();
        String dataDir = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "contract/";
        String filePath = dataDir + "20221020.pdf";
        Locale locale = new Locale("zh", "cn");
        Locale.setDefault(locale);
        Document pdfDocument = new Document(filePath);
        PageCollection pages = pdfDocument.getPages();
        
        Set<Integer> ocrPages = new HashSet<>();
        ocrPages.add(1);
        ocrPages.add(5);

        Resolution resolution = new Resolution(100);
        PngDevice pngDevice = new PngDevice(PageSize.getB5(), resolution);
        RenderingOptions renderingOptions = new RenderingOptions();
        renderingOptions.setOptimizeDimensions(true);
        renderingOptions.setUseNewImagingEngine(true);
        pngDevice.setRenderingOptions(renderingOptions);

        int index = 10;
        for (int i = 0; i < 10; i++) {
            for (Integer pageIndex : ocrPages) {
                long startTime = System.currentTimeMillis();
                Page page = pages.get_Item(pageIndex);
                String filepath = dataDir +"/image_" + (++index) +".png";
                //try(FileOutputStream fos = new FileOutputStream(filepath)) {
                //    //xImage.save(fos, ImageType.getPng());
                //}
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    pngDevice.process(page, baos);
                //XImageCollection images = pages.get_Item(pageIndex).getResources().getImages();
                System.out.println("花费的时间:" +(System.currentTimeMillis() - startTime));
            }
            
        }

        System.out.println("花费的时间:" + ( System.currentTimeMillis() - total)/10);
    }

    @Test
    public void modifyPDFJar() {
        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("/Users/xiao/Desktop/aspose.pdf-21.11.jar");
            //获取指定的class文件对象
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.pdf.l9f");
            //从class对象中解析获取所有方法
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
            for (CtMethod ctMethod : methodA) {
                //获取方法获取参数类型
                CtClass[] ps = ctMethod.getParameterTypes();
                //筛选同名方法，入参是Document
                if (ps.length == 1 && ctMethod.getName().equals("lI") && ps[0].getName().equals("java.io.InputStream")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    //替换指定方法的方法体
                    ctMethod.setBody("{this.l0if = com.aspose.pdf.l10if.lf;com.aspose.pdf.internal.imaging.internal.p71.Helper.help1();lI(this);}");
                }
            }
            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("/Users/xiao/Desktop/");

        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }
    
    @Test
    public void pdf1() {

        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("/Users/xiao/Desktop/aspose.pdf-21.11 8.jar");
            //获取指定的class文件对象
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.pdf.ADocument");
            //从class对象中解析获取所有方法
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
            for (CtMethod ctMethod : methodA) {
                //获取方法获取参数类型
                CtClass[] ps = ctMethod.getParameterTypes();
                //筛选同名方法，入参是Document
                if (ps.length == 2 && ctMethod.getName().equals("lI") && ps[0].getName().equals("com.aspose.pdf.ADocument")) {
                    System.out.println(ps[0].getName());
                    System.out.println(ps[1].getName());
                }
                if (ps.length == 2 && ctMethod.getName().equals("lI") && ps[0].getName().equals("com.aspose.pdf.ADocument") && ps[1].getName().equals("int")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    //替换指定方法的方法体
                    //ctMethod.setBody("{this.l0if = com.aspose.pdf.l10if.lf;com.aspose.pdf.internal.imaging.internal.p71.Helper.help1();lI(this);}");
                    ctMethod.setBody("{return false;}");
                }
                
                if (ctMethod.getName().equals("lt") && ps.length==0) {
                    ctMethod.setBody("{return false;}");
                }
            }
            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("/Users/xiao/Desktop/");

        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }
}
