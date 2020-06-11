package com.spider.test.wordUtil;

import com.spire.doc.Document;
import com.spire.doc.FileFormat;

public class DocUtil {
    public boolean updateAuthor(String filePath,String authorName){
        try {
            Document document = new Document(filePath);
            document.getBuiltinDocumentProperties().setAuthor(authorName);
            document.saveToFile(filePath);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
