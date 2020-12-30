package spring.dto;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReBoardDto {

    private String num;
    private String writer;
    private String pass;
    private String subject;
    private String content;
    private String upload;
    private List<MultipartFile> files;
    private int readcount;
    private int regroup;
    private int restep;
    private int relevel;
    private Timestamp writeday;
    private int cnt;//댓글 갯수 저장.

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }

    public int getReadcount() {
        return readcount;
    }

    public void setReadcount(int readcount) {
        this.readcount = readcount;
    }

    public int getRegroup() {
        return regroup;
    }

    public void setRegroup(int regroup) {
        this.regroup = regroup;
    }

    public int getRestep() {
        return restep;
    }

    public void setRestep(int restep) {
        this.restep = restep;
    }

    public int getRelevel() {
        return relevel;
    }

    public void setRelevel(int relevel) {
        this.relevel = relevel;
    }

    public Timestamp getWriteday() {
        return writeday;
    }

    public void setWriteday(Timestamp writeday) {
        this.writeday = writeday;
    }

    public boolean isImage(String filename) {
        int dotIdx = filename.indexOf(".");
        String ext = filename.substring(dotIdx + 1);

        return ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("jpg")
                || ext.equalsIgnoreCase("jpeg") || ext.equalsIgnoreCase("gif");
    }

}
