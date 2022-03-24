package org.xiao.rain.test.pdf;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.junit.Test;

/**
 * 
 * Author: xiaojl
 * Date: 2022/1/13 18:25
 */
public class CombinePdfTest {

    @Test
    public void combine() {

        String filePath = "/Users/xiao/Developer/57/ufsoft/xthome/temp/electnote/image/2.pdf";
        String target = "/Users/xiao/Developer/57/ufsoft/xthome/temp/electnote/pdf/2.pdf";
//        String filePath = "/Users/xiao/Developer/57/ufsoft/xthome/temp/electnote/image/696980316810001_20211214
//        -20211214_168A000380802_72833600008100C.jpg";
//        String target = "/Users/xiao/Developer/57/ufsoft/xthome/temp/electnote/pdf/696980316810001_20211214
//        -20211214_168A000380802_72833600008100C.pdf";


        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        try {
            pdfMerger.addSource(filePath);
//            String pdfFileName =  fileName.substring(0, fileName.indexOf(".")) +".pdf";
            pdfMerger.setDestinationFileName(target);
//            pdfMerger.setAcroFormMergeMode(pdfMerger.DocumentMergeMode.OPTIMIZE_RESOURCES_MODE);
            pdfMerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void imageToPdf() {
        String filePath = "/Users/xiao/Developer/57/ufsoft/xthome/temp/electnote/image/696980316810001_20211214" +
                "-20211214_168A000380802_72833600008100C.jpg";
        String target = "/Users/xiao/Developer/57/ufsoft/xthome/temp/electnote/pdf/696980316810001_20211214" +
                "-20211214_168A000380802_72833600008100C.pdf";


            byte[] fileBytes = toByteAarray(filePath);

        try {
            combineImage(fileBytes, target, "xxx.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static byte[] toByteAarray(String filePath)  {
        File file = new File(filePath);
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] bytes = null;
        try {
            byte[] b = new byte[1024];
            fis = new FileInputStream(file);
            baos = new ByteArrayOutputStream();
            int len = 0;
            while ((len = fis.read(b, 0, b.length)) != -1) {
                baos.write(b, 0, len);
            }
            bytes = baos.toByteArray();
        } catch (Exception e) {
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
            }
        }
        return bytes;
    }


    /**
     * 合并
     *
     * @throws Exception
     */
    private void combineImage(byte[] imgBytes, String pdfPath, String filename) throws Exception {
        PDDocument document = new PDDocument();
//        byte[] imgBytes = getImgBytes(path);
        PDPage imgPage = new PDPage();
        document.addPage(imgPage);
        PDRectangle pdRectangle = imgPage.getArtBox();
        PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, imgBytes, filename);
        //计算缩小放大倍数,使之按比例放大缩小
        float WidthMultiple = pdImage.getWidth() / pdRectangle.getWidth();
        float HeightMultiple = pdImage.getHeight() / pdRectangle.getHeight();
        float multiple = WidthMultiple > HeightMultiple ? WidthMultiple : HeightMultiple;
        try (PDPageContentStream contentStream = new PDPageContentStream(document, imgPage);) {
            //drawImage(PDImageXObject image, float x, float y, float width, float height)//以右上角为顶点放图片
            contentStream.drawImage(pdImage, 0, 0, pdImage.getWidth() / multiple, pdImage.getHeight() / multiple);
            imgPage.setCropBox(new PDRectangle(0, 0, pdImage.getWidth() / multiple, pdImage.getHeight() / multiple));

        }
        //手动释放下资源
//        imgBytes = null;

        document.save(pdfPath);
    }


}
