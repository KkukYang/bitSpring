package upload.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

public class SpringFileWriter {
	FileOutputStream fos;

	public void writeFile(MultipartFile file, String fileName, String path) {
		// 저장할 파일명.
//		String fileName = file.getOriginalFilename();
		try {
			byte fileData[] = file.getBytes();
			String tempPath = path + "/" + fileName;

			System.out.println("path + \"/\" + fileName : " + tempPath);

			fos = new FileOutputStream(tempPath);
			fos.write(fileData);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 파일명에 날짜를 붙여서 다시 리턴하기.
	public String changeFilename(String filename) {
		Calendar cal = Calendar.getInstance();
		String changeFilename = String.format("photo_%04d%02d%02d_%02d%02d%02d_%s", cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE), cal.get(Calendar.HOUR_OF_DAY),
				cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), filename);
		
//		Calendar cal = Calendar.getInstance();
//		String day = cal.get(Calendar.HOUR_OF_DAY) + "" + cal.get(Calendar.MINUTE) + "" + cal.get(Calendar.SECOND);
//		String changeFilename = "photo" + day + "_" + filename;
		
		return changeFilename;
	}
}
