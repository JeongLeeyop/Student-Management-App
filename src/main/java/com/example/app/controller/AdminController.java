package com.example.app.controller;

import com.example.app.model.domain.Season;
import com.example.app.model.domain.section.Section;
import com.example.app.model.domain.section.Task;
import com.example.app.model.dto.response.totalGradeResponse;
import com.example.app.service.AdminService;
import com.example.app.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ClassService classService;
    @Autowired
    AdminService adminService;

/*    //1. 클래스의 섹션을 조회하는 기능
    @RequestMapping("findSeasonList")
    @ResponseBody
    public List<Season> findSeasonList(HttpSession session) {
        return adminService.findSeasonList(session);
    }*/

    //4. 관리자 화면
    @RequestMapping("")
    public ModelAndView admin() {
//        log.debug("admin");
        ModelAndView view = new ModelAndView("/admin/admin");
        return view;
    }

    //4. 관리자 - 시즌 관리
    @RequestMapping("/season_setting")
    public ModelAndView season_setting() {
//        log.debug("admin/season_setting");
        ModelAndView view = new ModelAndView("/admin/season_setting");
        return view;
    }

    //4. 관리자 - 선생님 관리
    @RequestMapping("/teacher_setting")
    public ModelAndView teacher_setting() {
//        log.debug("admin/teacher_setting");
        ModelAndView view = new ModelAndView("/admin/teacher_setting");
        return view;
    }


/*
    //1. 클래스의 섹션을 추가하는 기능
    @RequestMapping("addSection")
    @ResponseBody
    public Section addSection(Long curClassIdx, String sectionName,Long curSectionIdx) {
        return classService.addSection(curClassIdx,sectionName,curSectionIdx);
    }

    //2. 클래스의 섹션을 삭제하는 기능
    @RequestMapping("delSection")
    @ResponseBody
    public void delSection(Long curSectionIdx) {
        classService.delSection(curSectionIdx);

    }

    //3. 클래스의 섹션의 이름을 수정하는 기능
    @RequestMapping("sectionName")
    @ResponseBody
    public ModelAndView sectionName(HttpServletRequest req) {
        return null;
    }

    //4. 섹션의 과제 항목과 점수를 조회하는 기능
    @RequestMapping("findTaskChart")
    @ResponseBody
    public Map findTaskChart(Long curSectionIdx, Long curClassIdx, HttpSession session) {
        return classService.findTaskChart(curSectionIdx,curClassIdx,session);
    }

   *//* //4. 섹션의 기본 템플릿 제공
    @RequestMapping("findTaskTemplate")
    @ResponseBody
    public Map findTaskTemplate(Long curClassIdx, HttpSession session) {
        return classService.findTaskTemplate(curClassIdx,session);
    }*//*

    //5. 섹션의 과제 항목을 추가하는 기능
    @RequestMapping("addTask")
    @ResponseBody
    public Map<String, Object> addTask(Long curClassIdx,Long curSectionIdx) {
        return classService.addTask(curClassIdx,curSectionIdx);
    }

    //6. 섹션의 과제 항목을 삭제하는 기능
    @RequestMapping("class_delTask")
    public ModelAndView delTask(Long sectionTasksIdx) {
        classService.delTask(sectionTasksIdx);
        return null;
    }

    //7. 섹션의 과제 항목을 수정하는 기능
    @RequestMapping("class_changeTask")
    public ModelAndView taskName(Long sectionTasksIdx, Long targetTaskIdx) {
        classService.changeTask(sectionTasksIdx,targetTaskIdx);
        return null;
    }

    //8. 과제 점수를 입력, 수정하는 기능
    @RequestMapping("saveTaskScore")
    @ResponseBody
    public ModelAndView saveTaskScore(@RequestParam String taskChart, Long curSectionIdx, @RequestParam String sectionTasksList) throws Exception{
        classService.saveTaskScore(taskChart,curSectionIdx, sectionTasksList);
        return null;
    }

    //9. 과제 정보를 출력해주는 기능 : 성적비율
    @RequestMapping("findTaskList")
    @ResponseBody
    public List<Task> findTaskList(Long curClassIdx) throws Exception{
        return classService.findTaskList(curClassIdx);
    }

    //10. 전체 학생 목록을 출력하여 등급 항목에 과제 항목의 점수를 반영하여 조회해주는 기능
    @RequestMapping("findTotalGrade")
    @ResponseBody
    public List<totalGradeResponse> findTotalGrade(Long curClassIdx, HttpSession session) {
        return classService.findTotalGrade(curClassIdx,session);
    }

    */
}