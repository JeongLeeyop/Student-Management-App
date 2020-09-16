package com.example.app.repository;

import com.example.app.model.domain.Account;
import com.example.app.model.domain.Student;
import com.example.app.model.domain.section.TaskItemInfo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface TaskItemInfoRepository extends CrudRepository<TaskItemInfo, Long> {
    public List<TaskItemInfo> findTaskItemInfoBy_class_ClassIdx(Long classIdx);

    @Query("DELETE FROM TaskItemInfo t where t._class.classIdx = ?1")
    @Transactional
    @Modifying
    public void DelTaskInfoByClassIdx(Long ClassIdx);

    @Query("select t from TaskItemInfo t where t._class.classIdx = ?1 Order By t.taskItemInfoIdx")
    public List<TaskItemInfo> findTaskItemInfoByClassIdx(Long curClassIdx);

    @Transactional
    @Modifying
    @Query("update TaskItemInfo t set t.maxScore = ?2 where t.taskItemInfoIdx=?1")
    public void updateMaxScore(Long taskItemInfoIdx,Double maxScore);


}
