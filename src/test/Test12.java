package test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用于数据库备份操作
 */
public class Test12 {
    private static Properties pros = getPprVue("db.properties");
    public static Map<String, String> backUpTableList = new ConcurrentHashMap<String, String>();
    private static Test12 backObj = new Test12();

    public static Test12 getDbBackUpMethod() {
        return backObj;
    }

    public void backup(String tableName) {
        if (null != backUpTableList.get(tableName)) return;
        backUpTableList.put(tableName, tableName); // 标记已经用于备份
        new Thread(new DbBackUpThread(tableName)).start();
    }

    /**
     * 用于执行某表的备份
     */
    class DbBackUpThread implements Runnable {
        String tableName = null;

        public DbBackUpThread(String tableName) {
            this.tableName = tableName;
        }

        @Override
        public void run() {
            try {
                String username = pros.getProperty("username");
                String password = pros.getProperty("password");
                String mysqlpaths = pros.getProperty("mysqlpath");
                String address = pros.getProperty("dbAddress");
                String databaseName = pros.getProperty("databaseName");
                String sqlpath = pros.getProperty("sqlFilePath");
                File backupath = new File(sqlpath);
                if (!backupath.exists()) {
                    backupath.mkdir();
                }
                StringBuffer sb = new StringBuffer();
                sb.append(mysqlpaths);
                sb.append("mysqldump ");
                sb.append("--opt ");
                sb.append("-h ");
                sb.append(address);
                sb.append(" ");
                sb.append("--user=");
                sb.append(username);
                sb.append(" ");
                sb.append("--password=");
                sb.append(password);
                sb.append(" ");
                sb.append("--lock-all-tables=true ");
                sb.append("--result-file=");
                sb.append(sqlpath);
                sb.append(tableName + ".sql");
                sb.append(" ");
                sb.append("--default-character-set=utf8 ");
                sb.append(databaseName);
                sb.append(" ");
                sb.append(tableName);
                Runtime cmd = Runtime.getRuntime();
                Process p = cmd.exec(sb.toString());
                p.waitFor(); // 该语句用于标记，如果备份没有完成，则该线程持续等待
            } catch (Exception e) {
                e.getMessage();
            } finally {
                backUpTableList.remove(tableName); // 最终都将解除
            }
        }
    }

    public static Properties getPprVue(String properName) {
        InputStream inputStream = Test12.class.getClassLoader().getResourceAsStream(properName);
        Properties p = new Properties();
        try {
            p.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.getMessage();
        }
        return p;
    }
}