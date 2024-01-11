package bitcamp.myapp.Dao;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public abstract class AbstractDao<T> {

    protected ArrayList<T> list;
    private String filepath;

    public AbstractDao(String filepath) {
        this.filepath = filepath;
        loadData();
    }


    protected void loadData() {

        try (BufferedReader in = new BufferedReader(new FileReader(filepath))) {

            // 파일에서 JSON 문자열을 모두 읽어서 버퍼에 저장한다.
            StringBuilder strBuilder = new StringBuilder();
            String str;
            while ((str = in.readLine()) != null) {
                strBuilder.append(str);
            }
            Class<T> datatype = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];

            list = (ArrayList<T>) new GsonBuilder().setDateFormat("yyyy-MM-dd").create()
                .fromJson(
                    strBuilder.toString(),
                    TypeToken.getParameterized(ArrayList.class, datatype));

        } catch (Exception e) {
            list = new ArrayList<>();
            throw new DaoException("데이터 로딩 오류!", e);
        }
    }

    protected void saveData() {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filepath))) {
            out.write(new GsonBuilder().setDateFormat("yyyy-MM-dd").create().toJson(list));
        } catch (Exception e) {
            throw new DaoException("데이터 저장 오류!", e);
        }
    }
}
