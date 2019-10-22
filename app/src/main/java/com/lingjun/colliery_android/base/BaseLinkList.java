package com.lingjun.colliery_android.base;

/**
 * Created by nefa on 2018/7/12.
 */

public class BaseLinkList {

    /**
     * 4个矿的地址
     */
    public static final String apiurl = "apiurl";

    //测试
    public static final String coal_mine = "http://134.175.189.65:8989/safety";
    public static final String Base_Url = "http://134.175.189.65:8881/forwardhandout/dispatch";

    //
//    public static final String coal_mine = "http://192.168.1.166:8080/safety";
//    public static final String Base_Url = "http://192.168.1.166:8888/forwardhandout/dispatch";
//    public static final String Base_Url = "http://192.168.0.143:8888/forwardhandout/dispatch";

//    public static final String coal_mine = "http://192.168.1.206:8080/safety";
//    public static final String coal_mine = "http://192.168.0.198:8080/safety";
//    public static final String Base_Url = "http://192.168.1.206:8090/forwardhandout/dispatch";

//    public static final String coal_mine = "http://192.168.1.223:8080/safety";
//    public static final String Base_Url = "http://192.168.1.223:8080/forwardhandout/dispatch";
//    //柠条塔
//    public static final String Base_Url = "http://117.36.230.172:40021/forwardhandout/dispatch";
//    public static final String coal_mine = "http://192.168.23.150:8888/safety";


//    public static final String Base_Url = "http://61.134.55.202:9096/forwardhandout/dispatch";
//    /**
//     * 玉华
//     */
//    public static final String coal_mine = "http://10.10.17.215:8080/safety";
    /**
     * 陈家山
     */
//    public static final String coal_mine = "http://10.10.15.44:8080/safety";
    /**
     * 下石节
     */
//    public static final String coal_mine = "http://10.10.16.232:8080/safety";
    /**
     * 柴家沟
     */
//    public static final String coal_mine = "http://10.10.34.181:8080/safety";
    /**
     * 双龙
     */
//    public static final String coal_mine = "http://134.175.189.65:8888/shuanglong";

    //
    public static final String upgrade_app = "/mobile/getVersonInfo";
    //首页公告通知
    public static final String Noticelist = "/mobile/noticelist";
    //首页公告通知详情
    public static final String Noticedetail = "/mobile/noticedetail";
    //待办列表
    public static final String todoTask = "/mobile/todotask";
    //登录
    public static final String login = "/sys/login";
    //获取责任人
    public static final String disobeyDepartmentlist = "/mobile/disobeyDepartmentlist";
    //文件上传
    public static final String getUpload = "/mobile/getUpload";
    //不安全行为条目
    public static final String clausecategorytree = "/mobile/clausecategorytree";
    //不安全行为详细内容
    public static final String clauselistBycategoryid = "/mobile/clauselistBycategoryid";
    //删除
    public static final String getDeletePic = "/mobile/getDeletePic";
    //带ID 删除
    public static final String DisobeyDeletePic = "/mobile/DisobeyDeletePic";
    //审核人
    public static final String disobeyinit = "/mobile/disobeyinit";
    //三违录入提交
    public static final String disobeyadd = "/mobile/disobeyadd";
    //三违驳回提交
    public static final String disobeymodify = "/mobile/disobeymodify";
    //三违管理列表
    public static final String disobeylist = "/mobile/disobeylist";
    //三违单信息
    public static final String disobeyinfo = "/mobile/disobeyinfo";
    //三违销号
    public static final String disobeysave = "/mobile/disobeysave";
    //三违历史
    public static final String disobeyhistorylist = "/mobile/disobeyhistorylist";
    //webview
    public static final String getCurrEmployeeno = "/mobile/getCurrEmployeeno";
    //三违历史归档
    public static final String rectifyingViolation = "/mobile/rectifyingViolation";
    //三违领导
    public static final String getdisobeyLeader = "/mobile/getdisobeyLeader";
    //三违接受
    public static final String disobeyconfirm = "/mobile/disobeyconfirm";
    //三违申诉类型集合
    public static final String disobeyappeallist = "/mobile/disobeyappeallist";
    //三违申诉
    public static final String disobeyappeal = "/mobile/disobeyappeal";
    //三违原方案仲裁
    public static final String disobeyconfirmfinally = "/mobile/disobeyconfirmfinally";
    //三违修改等级
    public static final String disobeymodifylevelinit = "/mobile/disobeymodifylevelinit";
    //三违被申诉修改处罚
    public static final String disobeymodifylevel = "/mobile/disobeymodifylevel";
    //三违检查人列表
    public static final String disobeyUserList = "/mobile/disobeyUserList";


    /**
     * 消息
     */
    public static final String getMessageType = "/mobile/getMessageType";
    public static final String getMessageList = "/mobile/getMessageList";
    //消息风险异常
    public static final String getRiskMeassesinfo = "/mobile/getRiskMeassesinfo";
    //消息消失
    public static final String updateMessageState = "/mobile/updateMessageState";
    //三违信息
    public static final String rectify = "/mobile/disobeyinfo";
    //借阅申请
    public static final String getBorNoticeDetail = "/mobile/getBorNoticeDetail";

    /**
     * 录入隐患
     */
    //选择历史隐患位置
    public static final String hidden_position = "/mobile/selectLocation";
    //专项计划列表
    public static final String hidden_plan = "/mobile/troubleplanlist";
    //隐患区域
    public static final String hidden_region = "/mobile/arealist";
    //录入时间和发现人
    public static final String fandpeople_time = "/mobile/init";
    //隐患录入关键字搜索
    public static final String pop_keyword = "/mobile/getSourcekeyWords";
    //隐患录入目录搜索
    public static final String pop_catalogword = "/mobile/getSourceFolders";
    //添加隐患源筛选
    public static final String hidden_content = "/mobile/getSelectSource";
    //隐患处理
    public static final String hidden_handle = "/mobile/getSourceList";
    //隐患提交
    public static final String hidden_submission = "/mobile/saveTrouble";
    //挂牌督办（录入隐患）
    public static final String hidden_supervise = "/mobile/getFatalConfirm";
    //处理方案（隐患升级）
    public static final String fg_four = "/mobile/getFatalTrouble";
    //隐患详情
    public static final String hidden_details = "/mobile/troubleinfo";
    //选择责任单位(录入隐患)
    public static final String hidden_responsibility = "/mobile/getSelectDepartment";
    //隐患等级
    public static final String hidden_grade = "/mobile/getTroubleLevel";
    //现场提交
//    public static final String submission_xc = "/mobile/getSelectMethod";
    public static final String saveAndSolutionCurrTrouble = "/mobile/saveAndSolutionCurrTrouble";
    //现场驳回提交
    public static final String updateAndSolutionCurrTrouble = "/mobile/updateAndSolutionCurrTrouble";
    //隐患升级审核人
    public static final String upgrade_auditor = "/mobile/getFatalApprove";
    //限时整改和挂牌督办
    public static final String limit_listing = "/mobile/getSelectLimitTime";
    public static final String saveAndSolutionLimitTrouble = "/mobile/saveAndSolutionLimitTrouble";
    //限时整改和挂牌督办驳回
    public static final String updateAndSolutionLimitTrouble = "/mobile/updateAndSolutionLimitTrouble";
    //待销号提交
    public static final String saveTypeButton = "/mobile/saveTypeButton";
    //隐患存储
    public static final String getSaveTypeButton = "/mobile/getSaveTypeButton";
    //隐患处理-->延期申请通过 status 11领导延期申请通过 flag-->12 12整改人延期通过  flag-->13）/驳回（督办，待办 5）/恢复 （督办 -1）
    public static final String delayPassOrReject = "/mobile/delayPassOrReject";
    //隐患历史
    public static final String getTroublehistory = "/mobile/getTroublehistory";
    //排查记录
    public static final String getclauselist = "/mobile/getClauseList";
    //隐患历史  1现场治理/5重大隐患  1存储2归档
    public static final String saveTypeButton_guidang = "/mobile/saveTypeButton";
    //隐患历史  2限时整改/3挂牌督办   1存储2归档
    public static final String getSaveTypeButton_guidang = "/mobile/getSaveTypeButton";
    //隐患审核人
    public static final String getleaderBydepartMent = "/mobile/getleaderBydepartMent";
    //协作单位
    public static final String getSelectCooperativeUnitDepartment = "/mobile/getSelectCooperativeUnitDepartment";
    //责任人/驗收人
    public static final String getUserByDepartmentId = "/mobile/getUserByDepartmentId";
    //验收单位
    public static final String getSelectAcceptDeparment = "/mobile/getSelectAcceptDeparment";
    //风险列表
    public static final String getRiskList = "/mobile/getRiskList";
    //风险详情
    public static final String getTroubleRisk = "/mobile/getTroubleRisk";
    //风险局领导
    public static final String getMineLeaderApp = "/mobile/getMineLeaderApp";
    //风险矿领导
    public static final String getCoalLeaderApp = "/mobile/getCoalLeaderApp";
    //风险 上报领导提交
    public static final String getRiskMeasses = "/mobile/getRiskMeasses";

    public static final String getUserLeaderByDepartment = "/mobile/getUserLeaderByDepartment";
    //协同单位开关接口
    public static final String getCollaborativeUnitsSwitch = "/mobile/getCollaborativeUnitsSwitch";
    //隐患审核人，验收人，验收单位
    public static final String getInputAcceptInfo = "/mobile/getInputAcceptInfo";
    //标准化列表
    public static final String getStadchkList = "/stadchk/getStadchkList";
    //标准化详情
    public static final String getSmallStadchk = "/stadchk/getStadchk";
    //标准化得分详情
    public static final String getStadchkProjectSocketInfo = "/stadchk/getStadchkProjectSocketInfo";


    /**
     * 待办接口
     */
    //根据id获得隐患信息
    public static final String troubleinfo = "/mobile/troubleinfo";
    //待办--> 现场治理、限时整改、挂牌督办、隐患升级 待审核,待确认 驳回接口
    public static final String getTODOCurrRefuseButton = "/mobile/getTODOCurrRefuseButton";
    //待办-->现场治理 待审核通过
    public static final String getTODOCurrButton = "/mobile/getTODOCurrButton";
    //待办-->限时整改、挂牌督办 待审核过接口
    public static final String getTODOLimitButton = "/mobile/getTODOLimitButton";
    //待办-->隐患升级通待审核过接口
    public static final String getFatalPassButton = "/mobile/getFatalPassButton";
    //待办-->重大隐患 待审核通过接口
    public static final String getFatalInfoButton = "/mobile/getFatalInfoButton";
    //待办-->验收 驳回接口
    public static final String getTODOAcceptRefuseButton = "/mobile/getTODOAcceptRefuseButton";
    //待办-->验收 验收完成
    public static final String getTODOAcceptContentButton = "/mobile/getTODOAcceptContentButton";
    //待办-->整改 整改完成
    public static final String rectifyIngButton = "/mobile/rectifyIngButton";
    //待办-->整改 延期申请
    public static final String troubledelayWriteProgram = "/mobile/troubledelayWriteProgram";
    //督办-->重新治理
    public static final String updateTroubleGPButton = "/mobile/updateTroubleGPButton";
    //风险管控
    public static final String risktodotask = "/mobile/getRiskTODOTask";
    //风险管控提交
    public static final String submitriskbutton = "/mobile/submitRiskButton";
    //任务详情
    public static final String MOBILE_GETSTADCHK = "/mobile/getStadchk";
    //检查重新待接收
    public static final String getMyStadchkTask = "/mobile/getMyStadchkTask";
    //待审核领导列表
    public static final String MOBILE_GETSTADCHKLEADERLIST = "/mobile/getStadchkLeaderlist";
    //待审核检查人员列表
    public static final String MOBILE_GETSTADCHKRESPONSIBLELIST = "/mobile/getStadchkResponsiblelist";
    //特邀人员列表
    public static final String MOBLIE_GETSTADCHKINVITEDLIST = "/mobile/getStadchkInvitedlist";
    //待审核配合人员列表
    public static final String MOBILE_GETSTADCHKCOOPERATORLIST = "/mobile/getStadchkCooperatorlist";
    //0分任务/满分任务/需检查任务
    public static final String MOBILE_GETSTADCHKNOCHECKITEMLIST = "/mobile/getStdchkNoCheckTaskitemlist";
    //待审核提交
    public static final String MOBILE_STDCHKCHECK = "/mobile/stdchkcheck";
    //待检查子任务详情
    public static final String MOBILE_GETSTADCHKITEMTASK = "/mobile/getStadchkitemtask";
    //待审阅任务提交
    public static final String MOBILE_STDCHKAPPROVE = "/mobile/stdchkapprove";
    //提交待检查任务结果
    public static final String MOBILE_SUBMITCHECK = "/mobile/submitcheck";
    //
    public static final String GetStdcheckTip = "/mobile/getStdcheckTip";

    //暂存待检查
    public static final String savecheck = "/mobile/savecheck";
    //
    public static final String submitcheckConfirm = "/mobile/submitcheckConfirm";
    //待接受任务提交
    public static final String MOBILE_USERTASKRECEIVE = "/mobile/usertaskreceive";
    //待检查资料
    public static final String MOBILE_GETCATALOGINLIST = "/stdEdtion/getEditionCataLogInListAPP";
    //待检查标准化资料目录
    public static final String MOBILE_GETCATALOGINFOLISTBYITEM = "/mobile/getCataLogInfoListByItem";
    //获取筛选资料类型
    public static final String MOBILE_GETBRANDS = "/mobile/getBrands";
    //待审阅某分类所有检查条目
    public static final String MOBLIE_GETSTADCHKITEMTASKLIST = "/mobile/getStadchkitemtasklist";
    //三违待审核驳回 和通过
    public static final String disobeycheck = "/mobile/disobeycheck";

    /**
     * 个人中心
     */
    //修改密码
    public static final String modifypwd = "/mobile/modifypwd";
    //修改用户信息
    public static final String modifyuser = "/mobile/modifyuser";

    /**
     * 标准化资料
     */
    //资料检索
    public static final String getEditionList = "/mobile/getEditionList";
    //获取借阅清单
    public static final String getBorrowList = "/mobile/getBorrowList";
    //获取借阅详情
    public static final String getApplyList = "/mobile/getApplyList";
    //申请借阅
    public static final String applyForborrowing = "/mobile/applyForborrowing";
    //任务跟踪
    public static final String getTaskfollowList = "/mobile/getTaskfollowList";
    //任务跟踪详情
    public static final String getApplyfollow = "/mobile/getApplyfollow";
    //关键词
    public static final String selectstdfilekeylists = "/stdEdtion/selectstdfilekeylists";
    //新资料上传
    public static final String saveEdition = "/stdEdtion/saveEditionAPP";
    //编辑资料
    public static final String updateEdition = "/stdEdtion/updateEditionAPP";
    //传输文件
    public static final String getTransferfile = "/mobile/getTransferfile";
    //传输文件提交
    public static final String filetransferButton = "/mobile/filetransferButton";
    //传输人员
    public static final String getTransferpeople = "/mobile/getTransferpeople";

    /**
     * 极光推送
     */
    public static final String updateRegistrationid = "/mobile/updateRegistrationid";

    public static final String TEAM = "/sysdepartment/departmentall";

    public static final String EXAMINEE = "/sysuser/getUserByDepartmentAndAdmin";

    public static final String inspectionbehavior = "/inspectionbehavior/insert";
}
