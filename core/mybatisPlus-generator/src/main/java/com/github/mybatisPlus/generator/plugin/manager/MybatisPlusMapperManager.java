package com.github.mybatisPlus.generator.plugin.manager;

import com.github.mybatisPlus.generator.plugin.MybatisPlusPackage;
import com.github.mybatisPlus.generator.plugin.config.MybatisPlusMapperConfiguration;
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
public class MybatisPlusMapperManager {

    public static void generateMapper(Interface interfaze, TopLevelClass entity, MybatisPlusMapperConfiguration configuration) {
        FullyQualifiedJavaType type = new FullyQualifiedJavaType(MybatisPlusPackage.BASE_MAPPER_PACKAGE);
        type.addTypeArgument(entity.getType());
        interfaze.addSuperInterface(type);
        interfaze.addImportedType(type);

        CommentTagUtil.addUnifyComment(interfaze);
    }
}
