package com.hostmdy.hmi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String subk;
	private String subject;
	private String subName;
	private String sub;
	private String suba;
	
	private String subb;
	private String subc;
	private String subd;
	private String sube;
	private String subf;
	
	private String subg;
	private String subh;
	private String subi;
	private String subj;
	private String subl;
	
	private String subm;
	private String subn;
	private String subo;
	private String subp;
	private String subq;
	
	@OneToOne(fetch = FetchType.EAGER)
	//@JsonIgnore
	private Program program;

	public Time(Long id, String subk, String subject, String subName, String sub, String suba, String subb, String subc,
			String subd, String sube, String subf, String subg, String subh, String subi, String subj, String subl,
			String subm, String subn, String subo, String subp, String subq, Program program) {
		super();
		this.id = id;
		this.subk = subk;
		this.subject = subject;
		this.subName = subName;
		this.sub = sub;
		this.suba = suba;
		this.subb = subb;
		this.subc = subc;
		this.subd = subd;
		this.sube = sube;
		this.subf = subf;
		this.subg = subg;
		this.subh = subh;
		this.subi = subi;
		this.subj = subj;
		this.subl = subl;
		this.subm = subm;
		this.subn = subn;
		this.subo = subo;
		this.subp = subp;
		this.subq = subq;
		this.program = program;
	}
	
	

}
