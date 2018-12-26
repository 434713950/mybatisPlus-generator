package com.github.mybatisPlus.generator.plugin.generator.mybatisplus;

import com.github.mybatisPlus.generator.plugin.MybatisPlusPackage;
import com.github.mybatisPlus.generator.plugin.generator.MapperGeneratorAdapter;
import com.github.mybatisPlus.generator.util.CommentTagUtil;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * <p></p>
 *
 * @author PengCheng
 * @date 2018/12/25
 */
public class MybatisPlusMapperGenerator implements MapperGeneratorAdapter {

    @Override
    public void generate(Interface interfaze, TopLevelClass entity) {
        addSuper(interfaze,entity);
        addComment(interfaze);
    }

    protected void addSuper(Interface interfaze,TopLevelClass entity){
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(MybatisPlusPackage.BASE_MAPPER_PACKAGE);
        type.addTypeArgument(entity.getType());
        interfaze.addSuperInterface(type);
        interfaze.addImportedType(type);
    }

    protected void addComment(Interface interfaze){
        CommentTagUtil.addUnifyComment(interfaze);
    }
}
