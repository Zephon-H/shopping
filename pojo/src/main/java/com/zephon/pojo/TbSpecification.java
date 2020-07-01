package com.zephon.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSpecification implements Serializable {
    private static final long serialVersionUID = 2L;
    private Long id;

    private String specName;

    private List<TbSpecificationOption> specificationOptionList;

    public List<TbSpecificationOption> getSpecificationOptionList() {
        return specificationOptionList;
    }

    public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList) {
        this.specificationOptionList = specificationOptionList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    @Override
    public String toString() {
        return "TbSpecification{" +
                "id=" + id +
                ", specName='" + specName + '\'' +
                ", specificationOptionList=" + specificationOptionList +
                '}';
    }
}