package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nefa on 2018/11/16.
 */

public class UnsafeBehaviorInfoBean implements Serializable {


    /**
     * msg : 成功
     * code : 200
     * data : {"list":[{"id":1,"categoryId":1,"description":"在炸药箱未上锁","number":1,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":"1","testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":"1","remark":null,"extraType":"3","extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":2,"categoryId":1,"description":"放炮私自摘风筒","number":2,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":3,"categoryId":1,"description":"井下睡觉","number":3,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":4,"categoryId":1,"description":"隐患未按期整改","number":4,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":5,"categoryId":1,"description":"用铁丝代替风管接头卡子","number":5,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":6,"categoryId":1,"description":"未发出开机信号，随意点动皮带","number":6,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":7,"categoryId":1,"description":"放炮后，未及时短接放炮母线","number":7,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":8,"categoryId":1,"description":"瓦检员脱岗","number":8,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":9,"categoryId":1,"description":"在填写民爆物品清退手册上有涂改","number":9,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":10,"categoryId":1,"description":"扒蹬跳","number":10,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":11,"categoryId":1,"description":"违反劳动纪律","number":11,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":12,"categoryId":1,"description":"斜巷运输未执行\u201c五人联签\u201d制度","number":12,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":13,"categoryId":1,"description":"扰乱车场排队秩序","number":13,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":14,"categoryId":1,"description":"提前回超前支护柱子，造成工作区域空顶面积大","number":14,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":15,"categoryId":1,"description":"安全出口提前回柱子，后落山提前放顶","number":15,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":16,"categoryId":1,"description":"工作面架前检修时，未对煤墙活体进行处理，未对帮部进行有效支护","number":16,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":17,"categoryId":1,"description":"后落山工作期间，未按要求悬挂瓦斯探头","number":17,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":18,"categoryId":1,"description":"工作面前落山提前放顶，摘柱子","number":18,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":19,"categoryId":1,"description":"工作面生产期间支架护帮板严重滞后煤机","number":19,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":20,"categoryId":1,"description":"高空作业未佩带保险带","number":20,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":21,"categoryId":1,"description":"工作面后端头放顶时，人员未及时撤出，违章作业","number":21,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":22,"categoryId":1,"description":"未随身携带自救器","number":22,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":23,"categoryId":1,"description":"放炮后，警戒未解除，私自放人员进入警戒区域","number":23,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":24,"categoryId":1,"description":"未按规程规定及时拉架，造成支架滞后","number":24,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":25,"categoryId":1,"description":"皮带运行期间用底皮带进行运输","number":25,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":26,"categoryId":1,"description":"未按要求排队乘车","number":26,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":27,"categoryId":1,"description":"工作面前端头作业时，戗柱未拴防倒绳","number":27,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":28,"categoryId":1,"description":"斜巷绞车运输时，没有设警戒人员","number":28,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":29,"categoryId":1,"description":"不打信号，随意点动绞车","number":29,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":30,"categoryId":1,"description":"皮带运行期间从皮带下穿越","number":30,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":31,"categoryId":1,"description":"阻车器未打牢固","number":31,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":32,"categoryId":1,"description":"运输时，把警戒不负责任，擅离职守","number":32,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":33,"categoryId":1,"description":"运输时把口不严，使人进入运输区域","number":33,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":34,"categoryId":1,"description":"未在规定地点坐车","number":34,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":35,"categoryId":1,"description":"皮带运转时，在皮带里侧作业","number":35,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":36,"categoryId":1,"description":"未连炮前，提前撒放放炮母线","number":36,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":37,"categoryId":1,"description":"放炮时，未按规定执行\u201c三人连锁\u201d制度","number":37,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":38,"categoryId":1,"description":"不走行人过桥，跨越运行中皮带或溜子","number":38,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":39,"categoryId":1,"description":"综掘机作业期间未按规定派设把警戒人员","number":39,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":40,"categoryId":1,"description":"工作面打锚杆时，未正确使用锚杆机，违章作业","number":40,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":41,"categoryId":1,"description":"保险带悬挂位置不当","number":41,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":42,"categoryId":1,"description":"放炮作业时，炸药箱未按规定放在警戒线以外","number":42,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":43,"categoryId":1,"description":"运输后，未恢复卡道器","number":43,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":44,"categoryId":1,"description":"不听从信号开绞车，违反运输规定","number":44,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":45,"categoryId":1,"description":"将放炮器随意乱放，未随身携带","number":45,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":46,"categoryId":1,"description":"违反规定坐药箱","number":46,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":47,"categoryId":1,"description":"无证上岗","number":47,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":48,"categoryId":1,"description":"未按指定路线行走，走运料通道","number":48,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":49,"categoryId":1,"description":"放炮作业，未使用水炮泥","number":49,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":50,"categoryId":1,"description":"皮带停后开关未及时停电闭锁","number":50,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":51,"categoryId":1,"description":"违反停送电制度","number":51,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":52,"categoryId":1,"description":"使用支护锚杆起吊","number":52,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":53,"categoryId":1,"description":"在移动式变压器上面躺卧休息","number":53,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":54,"categoryId":1,"description":"运输后，未及时对开关停电闭锁","number":54,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":55,"categoryId":1,"description":"违反运输规定，不遵守信号令","number":55,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":56,"categoryId":1,"description":"使用不规范连车装置","number":56,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":57,"categoryId":1,"description":"岗位工脱岗","number":57,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":58,"categoryId":1,"description":"报告制度执行不到位","number":58,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":59,"categoryId":1,"description":"工作面前端头后部溜子运转期间，进入老孔放顶","number":59,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":60,"categoryId":1,"description":"超前段单体柱子卸载，拒绝处理","number":60,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":61,"categoryId":1,"description":"转载机处移长梁时，人员未撤离，拉移转载机","number":61,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":62,"categoryId":1,"description":"运输作业前，未进行五人连签","number":62,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":63,"categoryId":1,"description":"打锚索施工期间戴手套握钻杆","number":63,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":64,"categoryId":1,"description":"放炮作业封泥长度不够，放炮前后未洒水","number":64,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":65,"categoryId":1,"description":"工作面干打眼，未开防尘喷雾","number":65,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":66,"categoryId":1,"description":"工作面机道内作业，未对煤墙帮部进行有效支护","number":66,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":67,"categoryId":1,"description":"工作面装药前脚线未短接","number":67,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":68,"categoryId":1,"description":"在岗期间打架","number":68,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":69,"categoryId":1,"description":"人为损坏各类牌板","number":69,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":70,"categoryId":1,"description":"追赶人车，在车辆未停稳时扒车","number":70,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":71,"categoryId":1,"description":"井下谩骂安检员，不听安全指挥","number":71,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":72,"categoryId":1,"description":"打击报复安检员","number":72,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":73,"categoryId":1,"description":"未执行停电闭锁挂牌制度，带电检修","number":73,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":74,"categoryId":1,"description":"工作面前段头长梁单挑梁（长梁支护不到位）","number":74,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":75,"categoryId":1,"description":"值班干部未组织人员参加每日安全风险评估会","number":75,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":76,"categoryId":1,"description":"爆破工将雷管给非涉爆人员","number":76,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":77,"categoryId":1,"description":"运输时，车辆超宽强行作业","number":77,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":78,"categoryId":1,"description":"未参加班前学习","number":78,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":79,"categoryId":1,"description":"半煤岩巷道施工过程中违反煤矿安全规程，私自使用耙斗机施工","number":79,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":80,"categoryId":1,"description":"单体柱子未拴防倒绳","number":80,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":81,"categoryId":1,"description":"乘坐电机车机头","number":81,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":82,"categoryId":1,"description":"行走大巷","number":82,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":83,"categoryId":1,"description":"拉运期间，未按规定板车销子未穿螺丝，进行闭锁","number":83,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":84,"categoryId":1,"description":"未戴安全帽","number":84,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":85,"categoryId":1,"description":"戴安全帽未系帽带","number":85,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":86,"categoryId":1,"description":"未按规定使用锚固剂","number":86,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":87,"categoryId":1,"description":"私自摘掉风筒","number":87,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":88,"categoryId":1,"description":"人车未停稳提前打开防护链","number":88,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":89,"categoryId":1,"description":"工作面移长梁时，跨步太大","number":89,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":90,"categoryId":1,"description":"平行作业","number":90,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":91,"categoryId":1,"description":"放炮警戒距离不够","number":91,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":92,"categoryId":1,"description":"大件车辆未捆绑牢固","number":92,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":93,"categoryId":1,"description":"升井未填写火工品领用记录","number":93,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":94,"categoryId":1,"description":"未按人车发车时间发人车，提前发人车","number":94,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":95,"categoryId":1,"description":"司机离开司控室，未拉下弓子断电，未取下司控手柄","number":95,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":96,"categoryId":1,"description":"未按要求延长风筒","number":96,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":97,"categoryId":1,"description":"工作面高压管未连接，未安全确认进行送液","number":97,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":98,"categoryId":1,"description":"工作面敲帮问顶执行不到位","number":98,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":99,"categoryId":1,"description":"放炮母线撒在电源传导体上","number":99,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":100,"categoryId":1,"description":"放炮后，炮烟未散直接进入工作面","number":100,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":101,"categoryId":1,"description":"雷管炸药未分离，乘坐车厢","number":101,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":102,"categoryId":1,"description":"上班迟到、班前会上睡觉","number":102,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":103,"categoryId":1,"description":"酒后入井","number":103,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":104,"categoryId":1,"description":"穿化纤衣服下井","number":104,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":105,"categoryId":1,"description":"携带烟草、明火入井","number":105,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":106,"categoryId":1,"description":"下井人员携带手机或其它电子物品","number":106,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":107,"categoryId":1,"description":"不执行入井检身制度","number":107,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":108,"categoryId":1,"description":"工作服衣袖不系扣，头灯、自救器斜背在肩上","number":108,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":109,"categoryId":1,"description":"戴安全帽不系带，上下班途中手拿安全帽，井下作业地点休息时取下安全帽当坐垫","number":109,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":110,"categoryId":1,"description":"井下作业时，私自拆卸矿灯自救器","number":110,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":111,"categoryId":1,"description":"不遵守乘车侯车、架空乘人车制度，互相嬉戏打闹，故意上下左右摆动，携带超长超重物件乘坐架空乘人车","number":111,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":112,"categoryId":1,"description":"人车未停稳上下车，从非行人侧上下车","number":112,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":113,"categoryId":1,"description":"上下人车，不走人行道，从车辆连接处穿过","number":113,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":114,"categoryId":1,"description":"扒、蹬、跳车","number":114,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":115,"categoryId":1,"description":"乘坐人车时，不挂防护链，互相嬉戏打闹","number":115,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":116,"categoryId":1,"description":"乘车时横七竖八乱躺，或将身体、携带物件伸出车外","number":116,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":117,"categoryId":1,"description":"井下2人及以上行走不排队","number":117,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":118,"categoryId":1,"description":"在井下巷道行走时，走道心","number":118,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":119,"categoryId":1,"description":"持过期证上岗","number":119,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":120,"categoryId":1,"description":"敲帮问顶不使用专用工具","number":120,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":121,"categoryId":1,"description":"用过的棉纱、布头不用铁桶盛装，乱扔乱放","number":121,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":122,"categoryId":1,"description":"人为损坏材料、设施，或将材料乱扔乱放","number":122,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1},{"id":123,"categoryId":1,"description":"不现场交接班","number":123,"levelId":1,"penaltyMoney":0,"penaltyLeaderMoney":0,"penaltyScore":0,"chapters":null,"testCount":0,"testScore":60,"enabled":1,"flags":0,"studyKeys":null,"remark":null,"extraType":null,"extraMoney":0,"name":null,"levelName":"一般","levelnumber":1}]}
     * resultMaps : []
     */

    private String msg;
    private String code;
    private DataBean data;
    private List<?> resultMaps;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public List<?> getResultMaps() {
        return resultMaps;
    }

    public void setResultMaps(List<?> resultMaps) {
        this.resultMaps = resultMaps;
    }

    public static class DataBean implements Serializable{
        private ArrayList<ListBean> list;

        public ArrayList<ListBean> getList() {
            return list;
        }

        public void setList(ArrayList<ListBean> list) {
            this.list = list;
        }

        public static class ListBean implements Serializable {
            /**
             * id : 1
             * categoryId : 1
             * description : 在炸药箱未上锁
             * number : 1
             * levelId : 1
             * penaltyMoney : 0
             * penaltyLeaderMoney : 0
             * penaltyScore : 0
             * chapters : 1
             * testCount : 0
             * testScore : 60
             * enabled : 1
             * flags : 0
             * studyKeys : 1
             * remark : null
             * extraType : 3
             * extraMoney : 0
             * name : null
             * levelName : 一般
             * levelnumber : 1
             */

            private int id;
            private int categoryId;
            private String description;
            private int number;
            private int levelId;
            private int penaltyMoney;
            private int penaltyLeaderMoney;
            private int penaltyScore;
            private String chapters;
            private int testCount;
            private int testScore;
            private int enabled;
            private int flags;
            private String studyKeys;
            private Object remark;
            private String extraType;
            private int extraMoney;
            private Object name;
            private String levelName;
            private int levelnumber;

            public boolean isType() {
                return type;
            }

            public void setType(boolean type) {
                this.type = type;
            }

            private boolean type=false;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getLevelId() {
                return levelId;
            }

            public void setLevelId(int levelId) {
                this.levelId = levelId;
            }

            public int getPenaltyMoney() {
                return penaltyMoney;
            }

            public void setPenaltyMoney(int penaltyMoney) {
                this.penaltyMoney = penaltyMoney;
            }

            public int getPenaltyLeaderMoney() {
                return penaltyLeaderMoney;
            }

            public void setPenaltyLeaderMoney(int penaltyLeaderMoney) {
                this.penaltyLeaderMoney = penaltyLeaderMoney;
            }

            public int getPenaltyScore() {
                return penaltyScore;
            }

            public void setPenaltyScore(int penaltyScore) {
                this.penaltyScore = penaltyScore;
            }

            public String getChapters() {
                return chapters;
            }

            public void setChapters(String chapters) {
                this.chapters = chapters;
            }

            public int getTestCount() {
                return testCount;
            }

            public void setTestCount(int testCount) {
                this.testCount = testCount;
            }

            public int getTestScore() {
                return testScore;
            }

            public void setTestScore(int testScore) {
                this.testScore = testScore;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getFlags() {
                return flags;
            }

            public void setFlags(int flags) {
                this.flags = flags;
            }

            public String getStudyKeys() {
                return studyKeys;
            }

            public void setStudyKeys(String studyKeys) {
                this.studyKeys = studyKeys;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getExtraType() {
                return extraType;
            }

            public void setExtraType(String extraType) {
                this.extraType = extraType;
            }

            public int getExtraMoney() {
                return extraMoney;
            }

            public void setExtraMoney(int extraMoney) {
                this.extraMoney = extraMoney;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public String getLevelName() {
                return levelName;
            }

            public void setLevelName(String levelName) {
                this.levelName = levelName;
            }

            public int getLevelnumber() {
                return levelnumber;
            }

            public void setLevelnumber(int levelnumber) {
                this.levelnumber = levelnumber;
            }
        }
    }
}
