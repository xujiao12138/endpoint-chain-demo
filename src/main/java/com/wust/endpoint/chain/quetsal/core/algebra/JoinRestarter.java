package com.wust.endpoint.chain.quetsal.core.algebra;

import com.fluidops.fedx.algebra.FedXExprVisitor;
import com.fluidops.fedx.algebra.NTuple;
import com.fluidops.fedx.structures.QueryInfo;
import org.eclipse.rdf4j.query.algebra.TupleExpr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class JoinRestarter extends NTuple {
	private static final long serialVersionUID = 2238788874854683628L;

	List<TopKSourceStatementPattern.Entry> entries = new ArrayList<TopKSourceStatementPattern.Entry>();
	
	public JoinRestarter(TupleExpr arg, List<TopKSourceStatementPattern> topksrcs, QueryInfo queryInfo) {
		super(Arrays.asList(arg), queryInfo);
		for (TopKSourceStatementPattern tksp : topksrcs) {
			List<TopKSourceStatementPattern.Entry> entrs = tksp.getEntries();
			entries.addAll(entrs);
		}
	}

	@Override
	public Set<String> getBindingNames() {
		return args.get(0).getBindingNames();
	}

	@Override
	public Set<String> getAssuredBindingNames() {
		return args.get(0).getAssuredBindingNames();
	}
	
	@Override
	public void visit(FedXExprVisitor v) {
		throw new RuntimeException("not implemented visit");
	}
	
	public List<TopKSourceStatementPattern.Entry> getEntries() {
		return entries;
	}
}
