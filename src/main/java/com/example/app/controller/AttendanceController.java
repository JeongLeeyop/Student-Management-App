package com.example.app.controller;

import com.example.app.model.domain.Attendance;
import com.example.app.model.domain.Season;
import com.example.app.model.dto.response.atCountResponse;
import com.example.app.model.dto.response.repository.AtSummaryResponse;
import com.example.app.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    //1.모든 날짜의 출석 요약을 조회하는 기능
    @ResponseBody
    @RequestMapping("findTotalAtSummary")
    public Map<String,Object> findTotalAtSummary(String strDate, HttpSession session)throws Exception {
        return attendanceService.findTotalAtSummary(strDate, session);
    }

    //1.모든 날짜의 출석 요약을 조회하는 기능
    @ResponseBody
    @RequestMapping("findTotalAtSummary2")
    public Map<String,Object> findTotalAtSummary2(Long curSeasonIdx,HttpSession session,String authStudentGroup)throws Exception {
        return attendanceService.findTotalAtSummary2(curSeasonIdx,session,authStudentGroup);
    }


    //1.선택 날짜의 학생별 출석여부를 조회하는 기능
    @ResponseBody
    @RequestMapping("findAtByDate")
    public List<Attendance> findAtByDate(String strDate,Long curSeasonIdx,HttpSession session,String authStudentGroup)throws Exception {
        return attendanceService.findAtByDate(strDate,curSeasonIdx,session,authStudentGroup);
    }

    //1.학생별 전체 출석을 조회하는 기능
    @ResponseBody
    @RequestMapping("findTotalAt")
    public List<atCountResponse> findTotalAt(Long curSeasonIdx,HttpSession session,String authStudentGroup)throws Exception {
        return attendanceService.findTotalAt(curSeasonIdx,session,authStudentGroup);
    }

    //2.선택 날짜의 학생별 출석여부를 입력,수정하는 기능
    @ResponseBody
    @RequestMapping("updateAt")
    public void updateAt( @RequestParam String dataArray ,String curDate)throws Exception{
        attendanceService.updateAt(dataArray,curDate);
//        return null;
    }

    //3.선택 날짜의 학생별 출석여부를 삭제하는 기능
    @ResponseBody
    @RequestMapping("deleteAt")
    public String deleteAt( String curDate,Long curSeasonIdx, HttpSession session,String authStudentGroup) {
        attendanceService.deleteAt(curDate,curSeasonIdx,session,authStudentGroup);
        return curDate;

    }

    //최초 시즌 설정
    @ResponseBody
    @RequestMapping("SeasonInit")
    public Long SeasonInit(HttpSession session) {
        return attendanceService.SeasonInit(session);
    }

    //AutoSave 수정
    @ResponseBody
    @RequestMapping("updateAutoSave")
    public Long updateAutoSave(HttpSession session, int autoSave) {
        attendanceService.updateAutoSave(session,autoSave);
        return null;
    }

    //AutoSave 찾기
    @ResponseBody
    @RequestMapping("findAutoSave")
    public int findAutoSave(HttpSession session) {
        return attendanceService.findAutoSave(session);
    }

    //AutoSave 수정
    @ResponseBody
    @RequestMapping("findLatelySeason")
    public Season findLatelySeason(HttpSession session) {
        return attendanceService.findLatelySeason(session);
    }

    //AuthStudentGroup 찾기
    @ResponseBody
    @RequestMapping("findAuthStudentGroup")
    public List<String> findAuthStudentGroup(HttpSession session, Long curSeasonIdx) {
        return attendanceService.findAuthStudentGroup(session,curSeasonIdx);
    }
}
