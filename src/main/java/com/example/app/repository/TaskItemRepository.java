package com.example.app.repository;

import com.example.app.model.dto.response.repository.TaskItemMapping;
import com.example.app.model.domain.section.Section;
import com.example.app.model.domain.section.TaskItem;
import com.example.app.model.dto.response.repository.UsedTaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface TaskItemRepository extends JpaRepository<TaskItem, Long> {
    @Query("DELETE FROM TaskItem t where t.taskItemInfo.taskItemInfoIdx = ?1")
    @Transactional
    @Modifying
    public void DelTaskItemByTaskItemInfoIdx(Long taskItemInfoIdx);

    @Query("DELETE FROM TaskItem t where t.taskItemInfo.taskItemInfoIdx in (select i from TaskItemInfo i where i._class.classIdx = ?1)")
    @Transactional
    @Modifying
    public void DelTaskItemByClassIdx(Long ClassIdx);

    @Query("DELETE FROM TaskItem t where t.section.sectionIdx = ?1")
    @Transactional
    @Modifying
    public void DelTaskItemBySectionIdx(Long sectionIdx);

    //과제 차트 데이터 불러오기
    public List<TaskItemMapping> findAllBySectionOrderByStudent(Section curSection);

    //사용중인 과제항목 불러오기
    public List<UsedTaskList> findDistinctBySection(Section section);

}
