package com.soecode.lyf.util;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.soecode.lyf.model.vo.FunctionVO;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author syrs
 */
public class TreeNodeUtil {
    private static final Logger logger = LoggerFactory.getLogger(TreeNodeUtil.class);

    /**
     * 获取对象的所有树状子集
     *
     * @param t              目标对象
     * @param list           数据集合
     * @param parentCodeName 父级属性名
     * @param codeName       子集属性名
     * @param childrenName   子集合属性名
     * @param <T>
     * @return T
     */
    public static <T> T setParents(T t, final List<T> list, final String parentCodeName, final String codeName, final String childrenName) {
        //集合中去掉当前对象
        Class<?> tClass = t.getClass();
        Object parentCodeValue = null;//目标编码的父级值
//		Field childrenNameField = null;
        try {
            Field parentCodeField = tClass.getDeclaredField(parentCodeName);
            parentCodeField.setAccessible(true);
            parentCodeValue = parentCodeField.get(t);
            tClass.getDeclaredField(codeName);
            Field childrenNameField = tClass.getDeclaredField(childrenName);
            if (!childrenNameField.getType().equals(List.class)) {
                logger.info("子类集合不存在，请检查");
                return null;
            }
        } catch (Exception e) {
            if (e instanceof NoSuchFieldException) {
                logger.info("属性不存在，请检查");
                return null;
            }
            return null;
        }
        final Object codeValueFinal = parentCodeValue;
        list.remove(t);
        List<T> parents = list.stream().filter(f -> {
            try {
                Field thisCodeField = f.getClass().getDeclaredField(codeName);
                thisCodeField.setAccessible(true);
                Object thisCodeValue = thisCodeField.get(f);
                return Objects.equals(codeValueFinal, thisCodeValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                logger.info(e.toString());
                return false;
            }
        }).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(parents)) {
            T parent = parents.get(0);
            try {
                Field parentCodeField = parent.getClass().getDeclaredField(childrenName);
                parentCodeField.setAccessible(true);
                parentCodeField.set(parent, Lists.newArrayList(t));
            } catch (IllegalAccessException | NoSuchFieldException e) {
                logger.info(e.toString());
                return null;
            }
            //集合中去掉已经处理的子类
            list.remove(parent);
            return setParents(parent, list, parentCodeName, codeName, childrenName);
        } else {
            return t;
        }
    }

    public static <T> T setChildrenByCodeValue(Object codeValue, final List<T> list, final String parentCodeName, final String codeName, final String childrenName) {
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        T o = null;
        try {
            Class<?> entityClass = list.iterator().next().getClass();
            o = (T)entityClass.newInstance();
            Field field = entityClass.getDeclaredField(codeName);
            field.setAccessible(true);
            field.set(o,codeValue);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        boolean setFlag = setChildren(o, list, parentCodeName, codeName, childrenName);
        if(!setFlag){
            return null;
        }
        return o;
    }

    /**
     * 获取对象的所有树状子集
     *
     * @param t              目标对象
     * @param list           数据集合
     * @param parentCodeName 父级属性名
     * @param codeName       子集属性名
     * @param childrenName   子集合属性名
     * @param <T>
     * @return
     */
    public static <T> boolean setChildren(T t, final List<T> list, final String parentCodeName, final String codeName, final String childrenName) {
        //集合中去掉当前对象
        Class<?> tClass = t.getClass();
        Object codeValue = null;//目标编码的值
        Field childrenNameField = null;
        try {
            Field codeField = tClass.getDeclaredField(codeName);
            codeField.setAccessible(true);
            codeValue = codeField.get(t);
            tClass.getDeclaredField(codeName);
            childrenNameField = tClass.getDeclaredField(childrenName);
            if (!childrenNameField.getType().equals(List.class)) {
                logger.info("子类集合不存在，请检查");
                return false;
            }
        } catch (Exception e) {
            if (e instanceof NoSuchFieldException) {
                logger.info("属性不存在，请检查");
                return false;
            }
            return false;
        }
        final Object codeValueFinal = codeValue;
        list.remove(t);
        List<T> children = list.stream().filter(f -> {
            try {
                Field thisCodeField = f.getClass().getDeclaredField(parentCodeName);
                thisCodeField.setAccessible(true);
                Object thisCodeValue = thisCodeField.get(f);
                return Objects.equals(codeValueFinal, thisCodeValue);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                logger.info(e.toString());
                return false;
            }
        }).collect(Collectors.toList());
        try {
            childrenNameField.setAccessible(true);
            childrenNameField.set(t, children);
        } catch (IllegalAccessException e) {
            logger.info(e.toString());
            return false;
        }
        //集合中去掉已经处理的子类
        list.removeAll(children);
        children.forEach(o -> setChildren(o, list, parentCodeName, codeName, childrenName));
        return true;
    }

    public static JSONObject getCurrentChildrensTree(Map<String, Map<String, Object>> allMap, Map<String, Map<String, Object>> curTreeMap, String curTreeMapInitIdValue, String curTreeMapParentIdKey) {
        for (Map.Entry<String, Map<String, Object>> bean : allMap.entrySet()) {
            String parentId = (String) bean.getValue().get(curTreeMapParentIdKey);
            // set default childern
            bean.getValue().put("children", new ArrayList<Map<String, Object>>());
            if (curTreeMap.containsKey(parentId)) {
                // add children
                List<Map<String, Object>> childrenList = (List<Map<String, Object>>) curTreeMap.get(parentId).get("children");
                childrenList.add(bean.getValue());
                // add record
                curTreeMap.put(bean.getKey(), bean.getValue());
            }
        }
        JSONObject result = new JSONObject();
        result.putAll(curTreeMap.get(curTreeMapInitIdValue));
        return result;
    }

    public static void main(String[] args) {

//        FunctionVO functionPO = new FunctionVO();
//        functionPO.setCode("aa");
//        functionPO.setParentCode("1");
//        FunctionVO functionPO1 = new FunctionVO();
//        functionPO1.setCode("aa1");
//        functionPO1.setParentCode("aa");
//        FunctionVO functionPO2 = new FunctionVO();
//        functionPO2.setCode("aa2");
//        functionPO2.setParentCode("aa1");
//        ArrayList<FunctionVO> list = Lists.newArrayList();
//        list.add(functionPO);
//        list.add(functionPO1);
//        list.add(functionPO2);
//        FunctionVO functionVO = TreeNodeUtil.setParents(functionPO2, list, "parentCode", "code", "children");
//        logger.info(JSONObject.toJSONString(functionVO));
        FunctionVO functionPO = new FunctionVO();
        functionPO.setCode("aa");
        functionPO.setParentCode("1");
        FunctionVO functionPO1 = new FunctionVO();
        functionPO1.setCode("aa1");
        functionPO1.setParentCode("aa");
        FunctionVO functionPO2 = new FunctionVO();
        functionPO2.setCode("aa2");
        functionPO2.setParentCode("aa1");
        FunctionVO function1PO = new FunctionVO();
        function1PO.setCode("a1a");
        function1PO.setParentCode("1");
        FunctionVO function2PO1 = new FunctionVO();
        function2PO1.setCode("a1a1");
        function2PO1.setParentCode("a1a");
        FunctionVO function3PO2 = new FunctionVO();
        function3PO2.setCode("aa2");
        function3PO2.setParentCode("a1a1");
        ArrayList<FunctionVO> list = Lists.newArrayList();
        list.add(functionPO);
        list.add(functionPO1);
        list.add(functionPO2);
        list.add(function1PO);
        list.add(function2PO1);
        list.add(function3PO2);
        FunctionVO function0PO = new FunctionVO();
        function0PO.setCode("1");

        FunctionVO vo = TreeNodeUtil.setChildrenByCodeValue("1", list, "parentCode", "code", "children");
//		TreeNodeUtil.setChildren(function0PO,list,"parentCode","code","children");
        System.out.println(JSONObject.toJSONString(vo));
    }

    private static Map<String, Map<String, Object>> getRecords() {
        Map<String, Map<String, Object>> result = new HashMap<>();

        // first record
        Map<String, Object> red01 = new HashMap<>();
        Map<String, Object> red0101 = new HashMap<>();


        Map<String, Object> red0102 = new HashMap<>();
        red0102.put("id", "U0004");
        red0102.put("name", "zhaolu");
        red0102.put("parentId", "U0001");
        result.put("U0004", red0102);

        red01.put("id", "U0001");
        red01.put("name", "zhengsan");
        red01.put("parentId", "00000");
        result.put("U0001", red01);

        Map<String, Object> red02 = new HashMap<>();
        red02.put("id", "U0002");
        red02.put("name", "lisi");
        red02.put("parentId", "00000");
        result.put("U0002", red02);

        red0101.put("id", "U0003");
        red0101.put("name", "wangwu");
        red0101.put("parentId", "U0001");
        result.put("U0003", red0101);


        Map<String, Object> red010101 = new HashMap<>();
        red010101.put("id", "U0005");
        red010101.put("name", "maqi");
        red010101.put("parentId", "U0003");
        result.put("U0005", red010101);

        Map<String, Object> red010102 = new HashMap<>();
        red010102.put("id", "U0006");
        red010102.put("name", "chenba");
        red010102.put("parentId", "U0003");
        result.put("U0006", red010102);

        return result;
    }
}
