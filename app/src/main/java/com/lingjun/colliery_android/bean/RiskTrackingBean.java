package com.lingjun.colliery_android.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者: zengtao
 * 时间: 2019/5/7  19:47.
 * 注释: 风险跟踪列表
 */
public class RiskTrackingBean implements Serializable {

    /**
     * msg : 成功
     * code : 200
     * data : {"page":{"pageNo":1,"pageSize":200,"totalRecord":21,"totalPage":1,"results":[{"id":22693,"planId":6,"planName":null,"riskcontrolAreaId":"66","riskcontrolAreaName":"采煤工作面","riskcontrolSourceId":12,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","riskcontrolSourceMeasures":"处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。","riskcontrolDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","publisherId":249,"publisherName":"王红伟","publisherTime":1556172797000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":22693,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1556208000000,"checkCycle":"1","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1556173003000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"不不不不不不不不","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20790,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554977937000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20790,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554978002000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20765,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554976762000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20765,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554976779000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20705,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554969810000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20705,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554969939000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":19738,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554714768000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":19738,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554652800000,"checkCycle":"2","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1554715016000,"checkdate":9,"checkState":"0","lastCheckdate":"2019-4-9","nextCheckdate":"2019-5-9","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":15049,"planId":9,"planName":null,"riskcontrolAreaId":"66","riskcontrolAreaName":"采煤工作面","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552445648000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":15049,"responsibleId":346,"responsibleName":"刘鹏","saveType":2,"beginDate":1552406400000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1552445913000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":13379,"planId":8,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552376463000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":13379,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1552320000000,"checkCycle":"2","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1552376513000,"checkdate":13,"checkState":"0","lastCheckdate":"2019-4-13","nextCheckdate":"2019-5-13","measures":"追加措施","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":11964,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552007385000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":11964,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551974400000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1552007495000,"checkdate":5,"checkState":"0","lastCheckdate":"2019-5-5","nextCheckdate":"2019-6-5","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8207,"planId":6,"planName":null,"riskcontrolAreaId":"20,19","riskcontrolAreaName":"北总进风巷,北回风斜井","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":648,"publisherName":"朱杰明","publisherTime":1551773717000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8207,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1551715200000,"checkCycle":"1","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1551774081000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"","lastFiledate":null},"implementcounts":1,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8206,"planId":7,"planName":null,"riskcontrolAreaId":"39","riskcontrolAreaName":"掘进工作面","riskcontrolSourceId":14,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"回采工作面上隅角瓦斯积聚","riskcontrolSourceMeasures":"1、综放工作面合理配置工作面风量，确保瓦斯抽采强度及效果，提高顶煤回收率，减少采空区遗煤，确保综放工作面上隅角瓦斯浓度符合要求。","riskcontrolDescription":"回采工作面上隅角瓦斯积聚","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755630000,"riskcontrolCategoryId":2,"riskcontrolCategoryName":"瓦斯","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8206,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755736000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施4","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8205,"planId":7,"planName":null,"riskcontrolAreaId":"24","riskcontrolAreaName":"一盘区西翼总回","riskcontrolSourceId":12,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","riskcontrolSourceMeasures":"处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。","riskcontrolDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755623000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8205,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"3","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755713000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施3","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8204,"planId":6,"planName":null,"riskcontrolAreaId":"39","riskcontrolAreaName":"掘进工作面","riskcontrolSourceId":124,"riskcontrolLevelId":2,"riskcontrolLevelName":"重大","riskcontrolSourceDescription":"通风系统紊乱或不可靠。","riskcontrolSourceMeasures":"通风系统调整时，出通风系统调整图。","riskcontrolDescription":"通风系统紊乱或不可靠。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755610000,"riskcontrolCategoryId":8,"riskcontrolCategoryName":"其他","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8204,"responsibleId":583,"responsibleName":"杨云峰","saveType":2,"beginDate":1551715200000,"checkCycle":"1","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755693000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-4-16","nextCheckdate":"2019-4-26","measures":"追加措施2","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8202,"planId":7,"planName":null,"riskcontrolAreaId":"63","riskcontrolAreaName":"其他","riskcontrolSourceId":121,"riskcontrolLevelId":2,"riskcontrolLevelName":"重大","riskcontrolSourceDescription":"火工品管理混乱，出入库手续不符合规定。当日没有用完的火工品没有按程序退库。","riskcontrolSourceMeasures":"1.建立完善的出入库登记管理制度并严格执行；2.坚持民爆物品领取、清退\u201c三备录\u201d原则。3.严格执行火工品领用、清点、退库等管理制度；4.严格按照《民爆物品安全管理》执行；5.定期对火工品进行安全专项检查。","riskcontrolDescription":"火工品管理混乱，出入库手续不符合规定。当日没有用完的火工品没有按程序退库。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755595000,"riskcontrolCategoryId":8,"riskcontrolCategoryName":"其他","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8202,"responsibleId":583,"responsibleName":"杨云峰","saveType":1,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755670000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施1","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4641,"planId":7,"planName":null,"riskcontrolAreaId":"47","riskcontrolAreaName":"探放水钻孔施工地点","riskcontrolSourceId":26,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"架棚支护的喷浆巷道顶煤易发生自燃","riskcontrolSourceMeasures":"火观员加强观测，发现异常及时汇报，进行处理。","riskcontrolDescription":"架棚支护的喷浆巷道顶煤易发生自燃","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527645000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4641,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527779000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu111","lastFiledate":null},"implementcounts":3,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4640,"planId":7,"planName":null,"riskcontrolAreaId":"47","riskcontrolAreaName":"探放水钻孔施工地点","riskcontrolSourceId":26,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"架棚支护的喷浆巷道顶煤易发生自燃","riskcontrolSourceMeasures":"火观员加强观测，发现异常及时汇报，进行处理。","riskcontrolDescription":"架棚支护的喷浆巷道顶煤易发生自燃","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527623000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4640,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527831000,"checkdate":16,"checkState":"2","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu2222222222222222","lastFiledate":null},"implementcounts":4,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4639,"planId":7,"planName":null,"riskcontrolAreaId":"46","riskcontrolAreaName":"防水闸墙","riskcontrolSourceId":25,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"密闭墙漏风供氧，易自然","riskcontrolSourceMeasures":"火观员加强密闭的日常检查巡查工作，发现问题立即汇报，进行处理，严禁出现漏风现象。","riskcontrolDescription":"密闭墙漏风供氧，易自然","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527601000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4639,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527972000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutuqwqwe","lastFiledate":null},"implementcounts":3,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4637,"planId":7,"planName":null,"riskcontrolAreaId":"46","riskcontrolAreaName":"防水闸墙","riskcontrolSourceId":25,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"密闭墙漏风供氧，易自然","riskcontrolSourceMeasures":"火观员加强密闭的日常检查巡查工作，发现问题立即汇报，进行处理，严禁出现漏风现象。","riskcontrolDescription":"密闭墙漏风供氧，易自然","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527560000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4637,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547528041000,"checkdate":16,"checkState":"2","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"youtu\r\n11","lastFiledate":null},"implementcounts":4,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4635,"planId":7,"planName":null,"riskcontrolAreaId":"42","riskcontrolAreaName":"运输系统","riskcontrolSourceId":36,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"采煤机、掘进机误操作造成人员伤害","riskcontrolSourceMeasures":"1、加强特殊作业人员培训教育，严格按章作业。\n2、采煤机、掘进机开机时，操作人员必须发出报警信号。\n3、采煤机正常作业时，滚筒前后5米范围内严禁有人；掘进机正常作业时，摇臂以前严禁有人。\n","riskcontrolDescription":"采煤机、掘进机误操作造成人员伤害","publisherId":648,"publisherName":"朱杰明","publisherTime":1547524273000,"riskcontrolCategoryId":6,"riskcontrolCategoryName":"机电","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4635,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524319000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu","lastFiledate":null},"implementcounts":2,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4634,"planId":7,"planName":null,"riskcontrolAreaId":"42","riskcontrolAreaName":"运输系统","riskcontrolSourceId":35,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"回采工作面高压管爆裂、锚链断裂","riskcontrolSourceMeasures":"1、定期对高压管路进行检查，发现损坏及时更换，乳化液泵压力符合规定。\n2、使用锚链时，人员必须撤离至安全地点。","riskcontrolDescription":"回采工作面高压管爆裂、锚链断裂","publisherId":648,"publisherName":"朱杰明","publisherTime":1547524034000,"riskcontrolCategoryId":6,"riskcontrolCategoryName":"机电","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4634,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524244000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"423youtu","lastFiledate":null},"implementcounts":1,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4630,"planId":7,"planName":null,"riskcontrolAreaId":"15","riskcontrolAreaName":"主井","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":648,"publisherName":"朱杰明","publisherTime":1547523408000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4630,"responsibleId":16,"responsibleName":"王雷石","saveType":2,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524127000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"youtu buxiashi","lastFiledate":null},"implementcounts":2,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4507,"planId":6,"planName":null,"riskcontrolAreaId":"48","riskcontrolAreaName":"井下各区域","riskcontrolSourceId":74,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"煤尘、浮煤堆积严重。","riskcontrolSourceMeasures":"通防科每周巡查各转载点、硐室，洒水灭尘。各区队严格按照《一通三防管理制度》做好防尘。督促运转队清理浮煤。","riskcontrolDescription":"煤尘、浮煤堆积严重。","publisherId":579,"publisherName":"王青峰","publisherTime":1547197586000,"riskcontrolCategoryId":3,"riskcontrolCategoryName":"煤尘","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4507,"responsibleId":249,"responsibleName":"王红伟","saveType":1,"beginDate":1554048000000,"checkCycle":"1","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1554172971000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"wwwwwwwww","lastFiledate":"2019-04-01"},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null}],"params":{"searchstr":"","checkstate":"","riskFlag":0},"resultMaps":[],"dateFormat":""}}
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

    public static class DataBean implements Serializable {
        /**
         * page : {"pageNo":1,"pageSize":200,"totalRecord":21,"totalPage":1,"results":[{"id":22693,"planId":6,"planName":null,"riskcontrolAreaId":"66","riskcontrolAreaName":"采煤工作面","riskcontrolSourceId":12,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","riskcontrolSourceMeasures":"处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。","riskcontrolDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","publisherId":249,"publisherName":"王红伟","publisherTime":1556172797000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":22693,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1556208000000,"checkCycle":"1","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1556173003000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"不不不不不不不不","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20790,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554977937000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20790,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554978002000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20765,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554976762000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20765,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554976779000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20705,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554969810000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20705,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554969939000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":19738,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554714768000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":19738,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554652800000,"checkCycle":"2","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1554715016000,"checkdate":9,"checkState":"0","lastCheckdate":"2019-4-9","nextCheckdate":"2019-5-9","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":15049,"planId":9,"planName":null,"riskcontrolAreaId":"66","riskcontrolAreaName":"采煤工作面","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552445648000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":15049,"responsibleId":346,"responsibleName":"刘鹏","saveType":2,"beginDate":1552406400000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1552445913000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":13379,"planId":8,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552376463000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":13379,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1552320000000,"checkCycle":"2","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1552376513000,"checkdate":13,"checkState":"0","lastCheckdate":"2019-4-13","nextCheckdate":"2019-5-13","measures":"追加措施","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":11964,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552007385000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":11964,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551974400000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1552007495000,"checkdate":5,"checkState":"0","lastCheckdate":"2019-5-5","nextCheckdate":"2019-6-5","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8207,"planId":6,"planName":null,"riskcontrolAreaId":"20,19","riskcontrolAreaName":"北总进风巷,北回风斜井","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":648,"publisherName":"朱杰明","publisherTime":1551773717000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8207,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1551715200000,"checkCycle":"1","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1551774081000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"","lastFiledate":null},"implementcounts":1,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8206,"planId":7,"planName":null,"riskcontrolAreaId":"39","riskcontrolAreaName":"掘进工作面","riskcontrolSourceId":14,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"回采工作面上隅角瓦斯积聚","riskcontrolSourceMeasures":"1、综放工作面合理配置工作面风量，确保瓦斯抽采强度及效果，提高顶煤回收率，减少采空区遗煤，确保综放工作面上隅角瓦斯浓度符合要求。","riskcontrolDescription":"回采工作面上隅角瓦斯积聚","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755630000,"riskcontrolCategoryId":2,"riskcontrolCategoryName":"瓦斯","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8206,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755736000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施4","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8205,"planId":7,"planName":null,"riskcontrolAreaId":"24","riskcontrolAreaName":"一盘区西翼总回","riskcontrolSourceId":12,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","riskcontrolSourceMeasures":"处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。","riskcontrolDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755623000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8205,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"3","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755713000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施3","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8204,"planId":6,"planName":null,"riskcontrolAreaId":"39","riskcontrolAreaName":"掘进工作面","riskcontrolSourceId":124,"riskcontrolLevelId":2,"riskcontrolLevelName":"重大","riskcontrolSourceDescription":"通风系统紊乱或不可靠。","riskcontrolSourceMeasures":"通风系统调整时，出通风系统调整图。","riskcontrolDescription":"通风系统紊乱或不可靠。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755610000,"riskcontrolCategoryId":8,"riskcontrolCategoryName":"其他","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8204,"responsibleId":583,"responsibleName":"杨云峰","saveType":2,"beginDate":1551715200000,"checkCycle":"1","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755693000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-4-16","nextCheckdate":"2019-4-26","measures":"追加措施2","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8202,"planId":7,"planName":null,"riskcontrolAreaId":"63","riskcontrolAreaName":"其他","riskcontrolSourceId":121,"riskcontrolLevelId":2,"riskcontrolLevelName":"重大","riskcontrolSourceDescription":"火工品管理混乱，出入库手续不符合规定。当日没有用完的火工品没有按程序退库。","riskcontrolSourceMeasures":"1.建立完善的出入库登记管理制度并严格执行；2.坚持民爆物品领取、清退\u201c三备录\u201d原则。3.严格执行火工品领用、清点、退库等管理制度；4.严格按照《民爆物品安全管理》执行；5.定期对火工品进行安全专项检查。","riskcontrolDescription":"火工品管理混乱，出入库手续不符合规定。当日没有用完的火工品没有按程序退库。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755595000,"riskcontrolCategoryId":8,"riskcontrolCategoryName":"其他","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8202,"responsibleId":583,"responsibleName":"杨云峰","saveType":1,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755670000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施1","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4641,"planId":7,"planName":null,"riskcontrolAreaId":"47","riskcontrolAreaName":"探放水钻孔施工地点","riskcontrolSourceId":26,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"架棚支护的喷浆巷道顶煤易发生自燃","riskcontrolSourceMeasures":"火观员加强观测，发现异常及时汇报，进行处理。","riskcontrolDescription":"架棚支护的喷浆巷道顶煤易发生自燃","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527645000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4641,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527779000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu111","lastFiledate":null},"implementcounts":3,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4640,"planId":7,"planName":null,"riskcontrolAreaId":"47","riskcontrolAreaName":"探放水钻孔施工地点","riskcontrolSourceId":26,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"架棚支护的喷浆巷道顶煤易发生自燃","riskcontrolSourceMeasures":"火观员加强观测，发现异常及时汇报，进行处理。","riskcontrolDescription":"架棚支护的喷浆巷道顶煤易发生自燃","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527623000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4640,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527831000,"checkdate":16,"checkState":"2","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu2222222222222222","lastFiledate":null},"implementcounts":4,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4639,"planId":7,"planName":null,"riskcontrolAreaId":"46","riskcontrolAreaName":"防水闸墙","riskcontrolSourceId":25,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"密闭墙漏风供氧，易自然","riskcontrolSourceMeasures":"火观员加强密闭的日常检查巡查工作，发现问题立即汇报，进行处理，严禁出现漏风现象。","riskcontrolDescription":"密闭墙漏风供氧，易自然","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527601000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4639,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527972000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutuqwqwe","lastFiledate":null},"implementcounts":3,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4637,"planId":7,"planName":null,"riskcontrolAreaId":"46","riskcontrolAreaName":"防水闸墙","riskcontrolSourceId":25,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"密闭墙漏风供氧，易自然","riskcontrolSourceMeasures":"火观员加强密闭的日常检查巡查工作，发现问题立即汇报，进行处理，严禁出现漏风现象。","riskcontrolDescription":"密闭墙漏风供氧，易自然","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527560000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4637,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547528041000,"checkdate":16,"checkState":"2","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"youtu\r\n11","lastFiledate":null},"implementcounts":4,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4635,"planId":7,"planName":null,"riskcontrolAreaId":"42","riskcontrolAreaName":"运输系统","riskcontrolSourceId":36,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"采煤机、掘进机误操作造成人员伤害","riskcontrolSourceMeasures":"1、加强特殊作业人员培训教育，严格按章作业。\n2、采煤机、掘进机开机时，操作人员必须发出报警信号。\n3、采煤机正常作业时，滚筒前后5米范围内严禁有人；掘进机正常作业时，摇臂以前严禁有人。\n","riskcontrolDescription":"采煤机、掘进机误操作造成人员伤害","publisherId":648,"publisherName":"朱杰明","publisherTime":1547524273000,"riskcontrolCategoryId":6,"riskcontrolCategoryName":"机电","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4635,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524319000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu","lastFiledate":null},"implementcounts":2,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4634,"planId":7,"planName":null,"riskcontrolAreaId":"42","riskcontrolAreaName":"运输系统","riskcontrolSourceId":35,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"回采工作面高压管爆裂、锚链断裂","riskcontrolSourceMeasures":"1、定期对高压管路进行检查，发现损坏及时更换，乳化液泵压力符合规定。\n2、使用锚链时，人员必须撤离至安全地点。","riskcontrolDescription":"回采工作面高压管爆裂、锚链断裂","publisherId":648,"publisherName":"朱杰明","publisherTime":1547524034000,"riskcontrolCategoryId":6,"riskcontrolCategoryName":"机电","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4634,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524244000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"423youtu","lastFiledate":null},"implementcounts":1,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4630,"planId":7,"planName":null,"riskcontrolAreaId":"15","riskcontrolAreaName":"主井","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":648,"publisherName":"朱杰明","publisherTime":1547523408000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4630,"responsibleId":16,"responsibleName":"王雷石","saveType":2,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524127000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"youtu buxiashi","lastFiledate":null},"implementcounts":2,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4507,"planId":6,"planName":null,"riskcontrolAreaId":"48","riskcontrolAreaName":"井下各区域","riskcontrolSourceId":74,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"煤尘、浮煤堆积严重。","riskcontrolSourceMeasures":"通防科每周巡查各转载点、硐室，洒水灭尘。各区队严格按照《一通三防管理制度》做好防尘。督促运转队清理浮煤。","riskcontrolDescription":"煤尘、浮煤堆积严重。","publisherId":579,"publisherName":"王青峰","publisherTime":1547197586000,"riskcontrolCategoryId":3,"riskcontrolCategoryName":"煤尘","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4507,"responsibleId":249,"responsibleName":"王红伟","saveType":1,"beginDate":1554048000000,"checkCycle":"1","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1554172971000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"wwwwwwwww","lastFiledate":"2019-04-01"},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null}],"params":{"searchstr":"","checkstate":"","riskFlag":0},"resultMaps":[],"dateFormat":""}
         */

        private PageBean page;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public static class PageBean implements Serializable {
            /**
             * pageNo : 1
             * pageSize : 200
             * totalRecord : 21
             * totalPage : 1
             * results : [{"id":22693,"planId":6,"planName":null,"riskcontrolAreaId":"66","riskcontrolAreaName":"采煤工作面","riskcontrolSourceId":12,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","riskcontrolSourceMeasures":"处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。","riskcontrolDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","publisherId":249,"publisherName":"王红伟","publisherTime":1556172797000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":22693,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1556208000000,"checkCycle":"1","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1556173003000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"不不不不不不不不","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20790,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554977937000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20790,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554978002000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20765,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554976762000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20765,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554976779000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":20705,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554969810000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":20705,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1554912000000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1554969939000,"checkdate":12,"checkState":"0","lastCheckdate":"2019-4-12","nextCheckdate":"2019-5-12","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":19738,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1554714768000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":19738,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1554652800000,"checkCycle":"2","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1554715016000,"checkdate":9,"checkState":"0","lastCheckdate":"2019-4-9","nextCheckdate":"2019-5-9","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":15049,"planId":9,"planName":null,"riskcontrolAreaId":"66","riskcontrolAreaName":"采煤工作面","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552445648000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":15049,"responsibleId":346,"responsibleName":"刘鹏","saveType":2,"beginDate":1552406400000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1552445913000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":13379,"planId":8,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552376463000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":13379,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1552320000000,"checkCycle":"2","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1552376513000,"checkdate":13,"checkState":"0","lastCheckdate":"2019-4-13","nextCheckdate":"2019-5-13","measures":"追加措施","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":11964,"planId":6,"planName":null,"riskcontrolAreaId":"","riskcontrolAreaName":"","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":249,"publisherName":"王红伟","publisherTime":1552007385000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":11964,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551974400000,"checkCycle":"2","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1552007495000,"checkdate":5,"checkState":"0","lastCheckdate":"2019-5-5","nextCheckdate":"2019-6-5","measures":"","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8207,"planId":6,"planName":null,"riskcontrolAreaId":"20,19","riskcontrolAreaName":"北总进风巷,北回风斜井","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":648,"publisherName":"朱杰明","publisherTime":1551773717000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8207,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1551715200000,"checkCycle":"1","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1551774081000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"","lastFiledate":null},"implementcounts":1,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8206,"planId":7,"planName":null,"riskcontrolAreaId":"39","riskcontrolAreaName":"掘进工作面","riskcontrolSourceId":14,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"回采工作面上隅角瓦斯积聚","riskcontrolSourceMeasures":"1、综放工作面合理配置工作面风量，确保瓦斯抽采强度及效果，提高顶煤回收率，减少采空区遗煤，确保综放工作面上隅角瓦斯浓度符合要求。","riskcontrolDescription":"回采工作面上隅角瓦斯积聚","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755630000,"riskcontrolCategoryId":2,"riskcontrolCategoryName":"瓦斯","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8206,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755736000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施4","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8205,"planId":7,"planName":null,"riskcontrolAreaId":"24","riskcontrolAreaName":"一盘区西翼总回","riskcontrolSourceId":12,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","riskcontrolSourceMeasures":"处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。","riskcontrolDescription":"冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755623000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8205,"responsibleId":583,"responsibleName":"杨云峰","saveType":3,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"3","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755713000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施3","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8204,"planId":6,"planName":null,"riskcontrolAreaId":"39","riskcontrolAreaName":"掘进工作面","riskcontrolSourceId":124,"riskcontrolLevelId":2,"riskcontrolLevelName":"重大","riskcontrolSourceDescription":"通风系统紊乱或不可靠。","riskcontrolSourceMeasures":"通风系统调整时，出通风系统调整图。","riskcontrolDescription":"通风系统紊乱或不可靠。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755610000,"riskcontrolCategoryId":8,"riskcontrolCategoryName":"其他","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8204,"responsibleId":583,"responsibleName":"杨云峰","saveType":2,"beginDate":1551715200000,"checkCycle":"1","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755693000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-4-16","nextCheckdate":"2019-4-26","measures":"追加措施2","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":8202,"planId":7,"planName":null,"riskcontrolAreaId":"63","riskcontrolAreaName":"其他","riskcontrolSourceId":121,"riskcontrolLevelId":2,"riskcontrolLevelName":"重大","riskcontrolSourceDescription":"火工品管理混乱，出入库手续不符合规定。当日没有用完的火工品没有按程序退库。","riskcontrolSourceMeasures":"1.建立完善的出入库登记管理制度并严格执行；2.坚持民爆物品领取、清退\u201c三备录\u201d原则。3.严格执行火工品领用、清点、退库等管理制度；4.严格按照《民爆物品安全管理》执行；5.定期对火工品进行安全专项检查。","riskcontrolDescription":"火工品管理混乱，出入库手续不符合规定。当日没有用完的火工品没有按程序退库。","publisherId":648,"publisherName":"朱杰明","publisherTime":1551755595000,"riskcontrolCategoryId":8,"riskcontrolCategoryName":"其他","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":8202,"responsibleId":583,"responsibleName":"杨云峰","saveType":1,"beginDate":1551715200000,"checkCycle":"2","fileCycle":"2","publisherId":648,"publisherName":"朱杰明","modifyTime":1551755670000,"checkdate":6,"checkState":"0","lastCheckdate":"2019-3-6","nextCheckdate":"2019-4-6","measures":"追加措施1","lastFiledate":null},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4641,"planId":7,"planName":null,"riskcontrolAreaId":"47","riskcontrolAreaName":"探放水钻孔施工地点","riskcontrolSourceId":26,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"架棚支护的喷浆巷道顶煤易发生自燃","riskcontrolSourceMeasures":"火观员加强观测，发现异常及时汇报，进行处理。","riskcontrolDescription":"架棚支护的喷浆巷道顶煤易发生自燃","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527645000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4641,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527779000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu111","lastFiledate":null},"implementcounts":3,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4640,"planId":7,"planName":null,"riskcontrolAreaId":"47","riskcontrolAreaName":"探放水钻孔施工地点","riskcontrolSourceId":26,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"架棚支护的喷浆巷道顶煤易发生自燃","riskcontrolSourceMeasures":"火观员加强观测，发现异常及时汇报，进行处理。","riskcontrolDescription":"架棚支护的喷浆巷道顶煤易发生自燃","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527623000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4640,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527831000,"checkdate":16,"checkState":"2","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu2222222222222222","lastFiledate":null},"implementcounts":4,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4639,"planId":7,"planName":null,"riskcontrolAreaId":"46","riskcontrolAreaName":"防水闸墙","riskcontrolSourceId":25,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"密闭墙漏风供氧，易自然","riskcontrolSourceMeasures":"火观员加强密闭的日常检查巡查工作，发现问题立即汇报，进行处理，严禁出现漏风现象。","riskcontrolDescription":"密闭墙漏风供氧，易自然","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527601000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4639,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547527972000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutuqwqwe","lastFiledate":null},"implementcounts":3,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4637,"planId":7,"planName":null,"riskcontrolAreaId":"46","riskcontrolAreaName":"防水闸墙","riskcontrolSourceId":25,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"密闭墙漏风供氧，易自然","riskcontrolSourceMeasures":"火观员加强密闭的日常检查巡查工作，发现问题立即汇报，进行处理，严禁出现漏风现象。","riskcontrolDescription":"密闭墙漏风供氧，易自然","publisherId":648,"publisherName":"朱杰明","publisherTime":1547527560000,"riskcontrolCategoryId":4,"riskcontrolCategoryName":"火灾","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4637,"responsibleId":167,"responsibleName":"于发根","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547528041000,"checkdate":16,"checkState":"2","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"youtu\r\n11","lastFiledate":null},"implementcounts":4,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4635,"planId":7,"planName":null,"riskcontrolAreaId":"42","riskcontrolAreaName":"运输系统","riskcontrolSourceId":36,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"采煤机、掘进机误操作造成人员伤害","riskcontrolSourceMeasures":"1、加强特殊作业人员培训教育，严格按章作业。\n2、采煤机、掘进机开机时，操作人员必须发出报警信号。\n3、采煤机正常作业时，滚筒前后5米范围内严禁有人；掘进机正常作业时，摇臂以前严禁有人。\n","riskcontrolDescription":"采煤机、掘进机误操作造成人员伤害","publisherId":648,"publisherName":"朱杰明","publisherTime":1547524273000,"riskcontrolCategoryId":6,"riskcontrolCategoryName":"机电","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4635,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524319000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"wutu","lastFiledate":null},"implementcounts":2,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4634,"planId":7,"planName":null,"riskcontrolAreaId":"42","riskcontrolAreaName":"运输系统","riskcontrolSourceId":35,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"回采工作面高压管爆裂、锚链断裂","riskcontrolSourceMeasures":"1、定期对高压管路进行检查，发现损坏及时更换，乳化液泵压力符合规定。\n2、使用锚链时，人员必须撤离至安全地点。","riskcontrolDescription":"回采工作面高压管爆裂、锚链断裂","publisherId":648,"publisherName":"朱杰明","publisherTime":1547524034000,"riskcontrolCategoryId":6,"riskcontrolCategoryName":"机电","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4634,"responsibleId":16,"responsibleName":"王雷石","saveType":1,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524244000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"423youtu","lastFiledate":null},"implementcounts":1,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4630,"planId":7,"planName":null,"riskcontrolAreaId":"15","riskcontrolAreaName":"主井","riskcontrolSourceId":9,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","riskcontrolSourceMeasures":"1、加强巷道顶板管理，巷道压力大的区域进行加强支护。\n2、正确规范使用支护材料，确保巷道成型效果。\n3、加强顶板离层检测仪的日常检修维护工作，确保数据真实，及时上传。","riskcontrolDescription":"顶板破碎、局部压力大、顶板淋水，造成巷道成型差，顶板下沉","publisherId":648,"publisherName":"朱杰明","publisherTime":1547523408000,"riskcontrolCategoryId":1,"riskcontrolCategoryName":"顶板","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4630,"responsibleId":16,"responsibleName":"王雷石","saveType":2,"beginDate":1547481600000,"checkCycle":"2","fileCycle":"1","publisherId":648,"publisherName":"朱杰明","modifyTime":1547524127000,"checkdate":16,"checkState":"0","lastCheckdate":"2019-5-16","nextCheckdate":"2019-6-16","measures":"youtu buxiashi","lastFiledate":null},"implementcounts":2,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null},{"id":4507,"planId":6,"planName":null,"riskcontrolAreaId":"48","riskcontrolAreaName":"井下各区域","riskcontrolSourceId":74,"riskcontrolLevelId":1,"riskcontrolLevelName":"一般","riskcontrolSourceDescription":"煤尘、浮煤堆积严重。","riskcontrolSourceMeasures":"通防科每周巡查各转载点、硐室，洒水灭尘。各区队严格按照《一通三防管理制度》做好防尘。督促运转队清理浮煤。","riskcontrolDescription":"煤尘、浮煤堆积严重。","publisherId":579,"publisherName":"王青峰","publisherTime":1547197586000,"riskcontrolCategoryId":3,"riskcontrolCategoryName":"煤尘","closeplanId":0,"closeplanTime":null,"lastcheckdate":null,"nextcheckdate":null,"states":2,"deleted":0,"closeplanReason":null,"measures":{"id":4507,"responsibleId":249,"responsibleName":"王红伟","saveType":1,"beginDate":1554048000000,"checkCycle":"1","fileCycle":"2","publisherId":249,"publisherName":"王红伟","modifyTime":1554172971000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"wwwwwwwww","lastFiledate":"2019-04-01"},"implementcounts":0,"remark":null,"implementState":0,"checkName":null,"checkdate":null,"riskcontrolsource":null,"riskcontrolplan":null}]
             * params : {"searchstr":"","checkstate":"","riskFlag":0}
             * resultMaps : []
             * dateFormat :
             */

            private int pageNo;
            private int pageSize;
            private int totalRecord;
            private int totalPage;
            private ParamsBean params;
            private String dateFormat;
            private List<ResultsBean> results;
            private List<?> resultMaps;

            public int getPageNo() {
                return pageNo;
            }

            public void setPageNo(int pageNo) {
                this.pageNo = pageNo;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public ParamsBean getParams() {
                return params;
            }

            public void setParams(ParamsBean params) {
                this.params = params;
            }

            public String getDateFormat() {
                return dateFormat;
            }

            public void setDateFormat(String dateFormat) {
                this.dateFormat = dateFormat;
            }

            public List<ResultsBean> getResults() {
                return results;
            }

            public void setResults(List<ResultsBean> results) {
                this.results = results;
            }

            public List<?> getResultMaps() {
                return resultMaps;
            }

            public void setResultMaps(List<?> resultMaps) {
                this.resultMaps = resultMaps;
            }

            public static class ParamsBean implements Serializable {
                /**
                 * searchstr :
                 * checkstate :
                 * riskFlag : 0
                 */

                private String searchstr;
                private String checkstate;
                private int riskFlag;

                public String getSearchstr() {
                    return searchstr;
                }

                public void setSearchstr(String searchstr) {
                    this.searchstr = searchstr;
                }

                public String getCheckstate() {
                    return checkstate;
                }

                public void setCheckstate(String checkstate) {
                    this.checkstate = checkstate;
                }

                public int getRiskFlag() {
                    return riskFlag;
                }

                public void setRiskFlag(int riskFlag) {
                    this.riskFlag = riskFlag;
                }
            }

            public static class ResultsBean implements Serializable {
                /**
                 * id : 22693
                 * planId : 6
                 * planName : null
                 * riskcontrolAreaId : 66
                 * riskcontrolAreaName : 采煤工作面
                 * riskcontrolSourceId : 12
                 * riskcontrolLevelId : 1
                 * riskcontrolLevelName : 一般
                 * riskcontrolSourceDescription : 冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。
                 * riskcontrolSourceMeasures : 处理冒顶时必须按照由外向里的顺序支护，清理干净退路，按照由外向里顺序支护；检查工作面顶板及巷帮支护情况，并进行敲帮问顶；敲帮问顶时，要及时观察顶板危岩，选择顶板完好，相对安全的地点站立；敲帮问顶时必须设置专人进行监护，并确保撤出路线畅通。
                 * riskcontrolDescription : 冒顶片帮未按照由外向里的顺序支护，退路未清理干净，未按照由外向里顺序支护，造成冒顶片帮、人员撤退时摔伤。
                 * publisherId : 249
                 * publisherName : 王红伟
                 * publisherTime : 1556172797000
                 * riskcontrolCategoryId : 1
                 * riskcontrolCategoryName : 顶板
                 * closeplanId : 0
                 * closeplanTime : null
                 * lastcheckdate : null
                 * nextcheckdate : null
                 * states : 2
                 * deleted : 0
                 * closeplanReason : null
                 * measures : {"id":22693,"responsibleId":167,"responsibleName":"于发根","saveType":2,"beginDate":1556208000000,"checkCycle":"1","fileCycle":"1","publisherId":249,"publisherName":"王红伟","modifyTime":1556173003000,"checkdate":1,"checkState":"0","lastCheckdate":"2019-4-21","nextCheckdate":"2019-5-1","measures":"不不不不不不不不","lastFiledate":null}
                 * implementcounts : 0
                 * remark : null
                 * implementState : 0
                 * checkName : null
                 * checkdate : null
                 * riskcontrolsource : null
                 * riskcontrolplan : null
                 */

                private int id;
                private int planId;
                private Object planName;
                private String riskcontrolAreaId;
                private String riskcontrolAreaName;
                private int riskcontrolSourceId;
                private int riskcontrolLevelId;
                private String riskcontrolLevelName;
                private String riskcontrolSourceDescription;
                private String riskcontrolSourceMeasures;
                private String riskcontrolDescription;
                private int publisherId;
                private String publisherName;
                private long publisherTime;
                private int riskcontrolCategoryId;
                private String riskcontrolCategoryName;
                private int closeplanId;
                private Object closeplanTime;
                private Object lastcheckdate;
                private Object nextcheckdate;
                private int states;
                private int deleted;
                private Object closeplanReason;
                private MeasuresBean measures;
                private int implementcounts;
                private Object remark;
                private int implementState;
                private Object checkName;
                private Object checkdate;
                private Object riskcontrolsource;
                private Object riskcontrolplan;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getPlanId() {
                    return planId;
                }

                public void setPlanId(int planId) {
                    this.planId = planId;
                }

                public Object getPlanName() {
                    return planName;
                }

                public void setPlanName(Object planName) {
                    this.planName = planName;
                }

                public String getRiskcontrolAreaId() {
                    return riskcontrolAreaId;
                }

                public void setRiskcontrolAreaId(String riskcontrolAreaId) {
                    this.riskcontrolAreaId = riskcontrolAreaId;
                }

                public String getRiskcontrolAreaName() {
                    return riskcontrolAreaName;
                }

                public void setRiskcontrolAreaName(String riskcontrolAreaName) {
                    this.riskcontrolAreaName = riskcontrolAreaName;
                }

                public int getRiskcontrolSourceId() {
                    return riskcontrolSourceId;
                }

                public void setRiskcontrolSourceId(int riskcontrolSourceId) {
                    this.riskcontrolSourceId = riskcontrolSourceId;
                }

                public int getRiskcontrolLevelId() {
                    return riskcontrolLevelId;
                }

                public void setRiskcontrolLevelId(int riskcontrolLevelId) {
                    this.riskcontrolLevelId = riskcontrolLevelId;
                }

                public String getRiskcontrolLevelName() {
                    return riskcontrolLevelName;
                }

                public void setRiskcontrolLevelName(String riskcontrolLevelName) {
                    this.riskcontrolLevelName = riskcontrolLevelName;
                }

                public String getRiskcontrolSourceDescription() {
                    return riskcontrolSourceDescription;
                }

                public void setRiskcontrolSourceDescription(String riskcontrolSourceDescription) {
                    this.riskcontrolSourceDescription = riskcontrolSourceDescription;
                }

                public String getRiskcontrolSourceMeasures() {
                    return riskcontrolSourceMeasures;
                }

                public void setRiskcontrolSourceMeasures(String riskcontrolSourceMeasures) {
                    this.riskcontrolSourceMeasures = riskcontrolSourceMeasures;
                }

                public String getRiskcontrolDescription() {
                    return riskcontrolDescription;
                }

                public void setRiskcontrolDescription(String riskcontrolDescription) {
                    this.riskcontrolDescription = riskcontrolDescription;
                }

                public int getPublisherId() {
                    return publisherId;
                }

                public void setPublisherId(int publisherId) {
                    this.publisherId = publisherId;
                }

                public String getPublisherName() {
                    return publisherName;
                }

                public void setPublisherName(String publisherName) {
                    this.publisherName = publisherName;
                }

                public long getPublisherTime() {
                    return publisherTime;
                }

                public void setPublisherTime(long publisherTime) {
                    this.publisherTime = publisherTime;
                }

                public int getRiskcontrolCategoryId() {
                    return riskcontrolCategoryId;
                }

                public void setRiskcontrolCategoryId(int riskcontrolCategoryId) {
                    this.riskcontrolCategoryId = riskcontrolCategoryId;
                }

                public String getRiskcontrolCategoryName() {
                    return riskcontrolCategoryName;
                }

                public void setRiskcontrolCategoryName(String riskcontrolCategoryName) {
                    this.riskcontrolCategoryName = riskcontrolCategoryName;
                }

                public int getCloseplanId() {
                    return closeplanId;
                }

                public void setCloseplanId(int closeplanId) {
                    this.closeplanId = closeplanId;
                }

                public Object getCloseplanTime() {
                    return closeplanTime;
                }

                public void setCloseplanTime(Object closeplanTime) {
                    this.closeplanTime = closeplanTime;
                }

                public Object getLastcheckdate() {
                    return lastcheckdate;
                }

                public void setLastcheckdate(Object lastcheckdate) {
                    this.lastcheckdate = lastcheckdate;
                }

                public Object getNextcheckdate() {
                    return nextcheckdate;
                }

                public void setNextcheckdate(Object nextcheckdate) {
                    this.nextcheckdate = nextcheckdate;
                }

                public int getStates() {
                    return states;
                }

                public void setStates(int states) {
                    this.states = states;
                }

                public int getDeleted() {
                    return deleted;
                }

                public void setDeleted(int deleted) {
                    this.deleted = deleted;
                }

                public Object getCloseplanReason() {
                    return closeplanReason;
                }

                public void setCloseplanReason(Object closeplanReason) {
                    this.closeplanReason = closeplanReason;
                }

                public MeasuresBean getMeasures() {
                    return measures;
                }

                public void setMeasures(MeasuresBean measures) {
                    this.measures = measures;
                }

                public int getImplementcounts() {
                    return implementcounts;
                }

                public void setImplementcounts(int implementcounts) {
                    this.implementcounts = implementcounts;
                }

                public Object getRemark() {
                    return remark;
                }

                public void setRemark(Object remark) {
                    this.remark = remark;
                }

                public int getImplementState() {
                    return implementState;
                }

                public void setImplementState(int implementState) {
                    this.implementState = implementState;
                }

                public Object getCheckName() {
                    return checkName;
                }

                public void setCheckName(Object checkName) {
                    this.checkName = checkName;
                }

                public Object getCheckdate() {
                    return checkdate;
                }

                public void setCheckdate(Object checkdate) {
                    this.checkdate = checkdate;
                }

                public Object getRiskcontrolsource() {
                    return riskcontrolsource;
                }

                public void setRiskcontrolsource(Object riskcontrolsource) {
                    this.riskcontrolsource = riskcontrolsource;
                }

                public Object getRiskcontrolplan() {
                    return riskcontrolplan;
                }

                public void setRiskcontrolplan(Object riskcontrolplan) {
                    this.riskcontrolplan = riskcontrolplan;
                }

                public static class MeasuresBean implements Serializable {
                    /**
                     * id : 22693
                     * responsibleId : 167
                     * responsibleName : 于发根
                     * saveType : 2
                     * beginDate : 1556208000000
                     * checkCycle : 1
                     * fileCycle : 1
                     * publisherId : 249
                     * publisherName : 王红伟
                     * modifyTime : 1556173003000
                     * checkdate : 1
                     * checkState : 0
                     * lastCheckdate : 2019-4-21
                     * nextCheckdate : 2019-5-1
                     * measures : 不不不不不不不不
                     * lastFiledate : null
                     */

                    private int id;
                    private int responsibleId;
                    private String responsibleName;
                    private int saveType;
                    private long beginDate;
                    private String checkCycle;
                    private String fileCycle;
                    private int publisherId;
                    private String publisherName;
                    private long modifyTime;
                    private int checkdate;
                    private String checkState;
                    private String lastCheckdate;
                    private String nextCheckdate;
                    private String measures;
                    private Object lastFiledate;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getResponsibleId() {
                        return responsibleId;
                    }

                    public void setResponsibleId(int responsibleId) {
                        this.responsibleId = responsibleId;
                    }

                    public String getResponsibleName() {
                        return responsibleName;
                    }

                    public void setResponsibleName(String responsibleName) {
                        this.responsibleName = responsibleName;
                    }

                    public int getSaveType() {
                        return saveType;
                    }

                    public void setSaveType(int saveType) {
                        this.saveType = saveType;
                    }

                    public long getBeginDate() {
                        return beginDate;
                    }

                    public void setBeginDate(long beginDate) {
                        this.beginDate = beginDate;
                    }

                    public String getCheckCycle() {
                        return checkCycle;
                    }

                    public void setCheckCycle(String checkCycle) {
                        this.checkCycle = checkCycle;
                    }

                    public String getFileCycle() {
                        return fileCycle;
                    }

                    public void setFileCycle(String fileCycle) {
                        this.fileCycle = fileCycle;
                    }

                    public int getPublisherId() {
                        return publisherId;
                    }

                    public void setPublisherId(int publisherId) {
                        this.publisherId = publisherId;
                    }

                    public String getPublisherName() {
                        return publisherName;
                    }

                    public void setPublisherName(String publisherName) {
                        this.publisherName = publisherName;
                    }

                    public long getModifyTime() {
                        return modifyTime;
                    }

                    public void setModifyTime(long modifyTime) {
                        this.modifyTime = modifyTime;
                    }

                    public int getCheckdate() {
                        return checkdate;
                    }

                    public void setCheckdate(int checkdate) {
                        this.checkdate = checkdate;
                    }

                    public String getCheckState() {
                        return checkState;
                    }

                    public void setCheckState(String checkState) {
                        this.checkState = checkState;
                    }

                    public String getLastCheckdate() {
                        return lastCheckdate;
                    }

                    public void setLastCheckdate(String lastCheckdate) {
                        this.lastCheckdate = lastCheckdate;
                    }

                    public String getNextCheckdate() {
                        return nextCheckdate;
                    }

                    public void setNextCheckdate(String nextCheckdate) {
                        this.nextCheckdate = nextCheckdate;
                    }

                    public String getMeasures() {
                        return measures;
                    }

                    public void setMeasures(String measures) {
                        this.measures = measures;
                    }

                    public Object getLastFiledate() {
                        return lastFiledate;
                    }

                    public void setLastFiledate(Object lastFiledate) {
                        this.lastFiledate = lastFiledate;
                    }
                }
            }
        }
    }
}
