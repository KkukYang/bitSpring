package react.board.data;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * -- auto-generated definition
 * create table reboard
 * (
 *     num       smallint auto_increment
 *         primary key,
 *     writer    varchar(20)        null,
 *     pass      varchar(20)        null,
 *     subject   varchar(1000)      null,
 *     content   varchar(2000)      null,
 *     upload    varchar(1000)      null,
 *     readcount smallint default 0 null,
 *     regroup   smallint           null,
 *     restep    smallint           null,
 *     relevel   smallint           null,
 *     writeday  datetime           null
 * );
 */

//@Data
public class ReactBoardDto {
	private String num;
	private String writer;
	private String title;
	private String photoname;
	private String content;
	private int readcount;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	private Timestamp writeday;



	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}



}
