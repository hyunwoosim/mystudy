package wooapp.myapp.dao;

import java.util.List;
import wooapp.myapp.vo.AttachedFile;

public interface AttachedFileDao {


        void add(AttachedFile file);

        int addAll(List<AttachedFile> files);

        int delete(int no);

        int deleteAll(int boardNo);

        List<AttachedFile> findAllByBoardNo(int boardNo);

        AttachedFile findByNo(int no);
    }



