package com.wust.endpoint.chain.quetsal.core.algebra;

import com.fluidops.fedx.algebra.NJoin;
import com.fluidops.fedx.structures.QueryInfo;
import org.eclipse.rdf4j.query.algebra.TupleExpr;

import java.util.ArrayList;
import java.util.List;

public class BindJoin extends NJoin {
	private static final long serialVersionUID = 1240385114646163120L;
	
	private static List<TupleExpr> createCollection(TupleExpr leftArg, TupleExpr rightArg) {
		List<TupleExpr> result = new ArrayList<TupleExpr>();
		result.add(leftArg);
		result.add(rightArg);
		return result;
	}
	
	public BindJoin(TupleExpr leftArg, TupleExpr rightArg, QueryInfo qi) {
		super(createCollection(leftArg, rightArg), qi);
	}
	
	public TupleExpr getLeftArg() {
		return this.getArg(0);
	}
	
	public TupleExpr getRightArg() {
		return this.getArg(1);
	}
}
