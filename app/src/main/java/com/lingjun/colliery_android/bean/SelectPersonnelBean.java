package com.lingjun.colliery_android.bean;

import java.util.ArrayList;

/**
 * Created by nefa on 2018/10/24.
 */

public class SelectPersonnelBean {

    private String entryName;
    private ArrayList<DepartmentBean> departmentList;


    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public ArrayList<DepartmentBean> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(ArrayList<DepartmentBean> departmentList) {
        this.departmentList = departmentList;
    }


    public static class DepartmentBean{
        private String departmentName;
        private ArrayList<PersonnelBean> personnelList;


        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public ArrayList<PersonnelBean> getPersonnelList() {
            return personnelList;
        }

        public void setPersonnelList(ArrayList<PersonnelBean> personnelList) {
            this.personnelList = personnelList;
        }

        public static class PersonnelBean{
            private String personnelName;
            private boolean isSelect;


            public boolean getIsSelect() {
                return isSelect;
            }

            public void setIsSelect(boolean isSelect) {
                this.isSelect = isSelect;
            }

            public String getPersonnelName() {
                return personnelName;
            }

            public void setPersonnelName(String personnelName) {
                this.personnelName = personnelName;
            }
        }
    }
}
