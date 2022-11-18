package ir.aliap1376ir.lib.jutil.log;

import com.ghasemkiani.util.icu.PersianCalendar;
import ir.aliap1376ir.lib.jutil.DateTimeUtil;
import ir.aliap1376ir.lib.jutil.StringPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BeautyLog {

    public void println() {
        beautyItLn(StringPool.BLANK);
    }

    public void println(boolean x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(char x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(int x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(long x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(float x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(double x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(char[] x) {
        beautyItLn(Arrays.toString(x) + StringPool.BLANK);
    }

    public void println(PersianCalendar x) {
        beautyItLn(DateTimeUtil.getPersianDate(x.getTimeInMillis()) + StringPool.BLANK);
    }

    public void println(String x) {
        beautyItLn(x + StringPool.BLANK);
    }

    public void println(Exception x) {
        beautyItLn(x.toString());
        x.printStackTrace();
    }

    public void println(Object x) {
        if (x == null) {
            beautyItLn(null + "");
        } else {
            beautyItLn(x.toString() + "");
        }
    }

    private void beautyItLn(String message) {
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        StackTraceElement element = elements[3];
        Logger logger = LoggerFactory.getLogger(element.getClassName());
        String fullMessage = element.getMethodName() + "(" + element.getClassName().substring(element.getClassName().lastIndexOf('.') + 1) + ".java:" + element.getLineNumber() + ") ";
        if (message != null && !message.isBlank()) {
            fullMessage += ":\n\t" + message;
        }
        logger.info(fullMessage);
    }
}