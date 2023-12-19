package nuc.edu.cn.chapter05_mybatis1_2113042727;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportCodeToWord {
    public static void main(String[] args) {
        String baseDirectory = "D:\\programmer\\ideacode\\springIocTest1\\src\\main\\java"; // 替换为你的目标文件夹路径
        String outputDocx = "output.docx";

        XWPFDocument document = new XWPFDocument();

        processDirectory(new File(baseDirectory), document);

        try (FileOutputStream out = new FileOutputStream(outputDocx)) {
            document.write(out);
            System.out.println("导出完成，文件已保存到 " + outputDocx);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processDirectory(File directory, XWPFDocument document) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file, document);
                } else if (file.isFile() && isTargetFile(file)) {
                    processFile(file, document);
                }
            }
        }
    }

    private static boolean isTargetFile(File file) {
        String fileName = file.getName();
        return fileName.endsWith(".java") || fileName.endsWith(".xml") || fileName.endsWith(".interface");
    }

    private static void processFile(File file, XWPFDocument document) {
        try (FileInputStream fis = new FileInputStream(file)) {
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setFontFamily("Courier New");
            run.setFontSize(12);

            paragraph.addRun(run);

            run.setText(file.getName());
            run.addCarriageReturn();

            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            run.setText(new String(bytes, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
