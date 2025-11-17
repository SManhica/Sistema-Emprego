
// src/main/java/com/gestaoemprego/dto/ChartDataDTO.java
package com.gestaoemprego.dto;

import java.util.List;
import java.util.Map;

public class ChartDataDTO {
    private String title;
    private String type = "pie";
    private List<Map<String, Object>> data;

    public ChartDataDTO(String title, List<Map<String, Object>> data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }
}