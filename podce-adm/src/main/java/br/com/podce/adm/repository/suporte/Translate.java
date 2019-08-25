package br.com.podce.adm.repository.suporte;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.Renderable;
import org.hibernate.query.criteria.internal.compile.RenderingContext;
import org.hibernate.query.criteria.internal.expression.function.BasicFunctionExpression;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import java.io.Serializable;

public class Translate extends BasicFunctionExpression<String> implements Serializable {
	
	public static final String NAME = "TRANSLATE";
	private Expression<String> argumentExpression;
	
	public Translate(CriteriaBuilder criteriaBuilder, Expression<String> argumentExpression) {
		super( (CriteriaBuilderImpl) criteriaBuilder, String.class, NAME);
		this.argumentExpression = argumentExpression;
	}
	
	
	public String render(RenderingContext renderingContext) {
		StringBuilder buffer = new StringBuilder();
		buffer.append( getFunctionName() )
		.append( "(" )
		.append(( (Renderable) argumentExpression ).render( renderingContext ))
		.append( "," )
		.append( "'ŠŽšžŸÁÇÉÍÓÚÀÈÌÒÙÂÊÎÔÛÃÕËÜÏÖÑÝåáçéíóúàèìòùâêîôûãõëüïöñýÿ'" )
		.append( "," )
		.append( "'SZszYACEIOUAEIOUAEIOUAOEUIONYaaceiouaeiouaeiouaoeuionyy'" )
		.append( ")" );
		
		return buffer.toString();
	}

}
