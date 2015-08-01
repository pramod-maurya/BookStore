package np.com.mshrestha.bookstore.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import np.com.mshrestha.bookstore.model.Logger;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logger")
public class LoggerController {

	@RequestMapping(value = { "" })
	@ResponseBody
	public Logger getMultipart(@ModelAttribute Logger logger) {

		try {
			fileWriter(logger);
		} catch (IOException e) {
			return null;
		}

		return logger;
	}

	

	@RequestMapping(value = { "json" })
	@ResponseBody
	public Logger getJson(@RequestBody Logger logger) {

		try {
			// File file = ResourceUtils.getFile("classpath:logger.txt");

			fileWriter(logger);
		} catch (IOException e) {
			return null;
		}

		return logger;
	}
	
	private synchronized void fileWriter(Logger logger) throws IOException {
		// File file = ResourceUtils.getFile("classpath:logger.txt");
		File file = new File("D://abc.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileUtils.write(file, "\nTimeStamp:  " + logger.getTimestamp(), true);
		FileUtils.write(file, "\nLoggerName:  " + logger.getLogger(), true);
		FileUtils.write(file, "\nLevel: " + logger.getLevel(), true);
		FileUtils.write(file, "\nUrl : " + logger.getUrl(), true);
		FileUtils.write(file, "\nMessage : " + logger.getMessage(), true);
		FileUtils.write(file, "\nException: " + logger.getException(), true);
		FileUtils.write(file, "\nLayout: " + logger.getLayout(), true);

		FileUtils.write(file, "\n====================\n", true);
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(HttpServletResponse response) {
		try {
			File file = new File("D://abc.txt");
			response.getOutputStream().write(FileUtils.readFileToByteArray(file));
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
