package com.example.algamoney.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.algamoney.api.model.Lancamento;
import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.LancamentoRepository;
import com.example.algamoney.api.repository.PessoaRepository;
import com.example.algamoney.api.repository.filter.LancamentoFilter;
import com.example.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class LancamentoService {
	
	private final LancamentoRepository lancamentoRepository;
	private final PessoaRepository pessoaRepository;
	
	public List<Lancamento> listar() {
		return this.lancamentoRepository.findAll();
	}
	
	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable) {
		return this.lancamentoRepository.filtrar(lancamentoFilter, pageable);
	}
	
	public Lancamento buscarLancamentoPeloCodigo(long codigo) {
		Lancamento lancamento =this.lancamentoRepository.findById(codigo).orElse(null);
		 if (lancamento == null) {
			 throw new EmptyResultDataAccessException(1);
		 }
		 return lancamento;
	}
	
	public Lancamento criar(Lancamento lancamento) {
		Pessoa pessoa = this.pessoaRepository.findById(lancamento.getPessoa().getCodigo()).orElse(null);
		if (pessoa == null || !pessoa.isAtivo()) {
			throw new PessoaInexistenteOuInativaException(); 
		}
		return this.lancamentoRepository.save(lancamento);
	}
	
	public Lancamento atualizar(long codigo, Lancamento lancamento) {
		Lancamento lancamentoSalva = this.buscarLancamentoPeloCodigo(codigo);
		BeanUtils.copyProperties(lancamento, lancamentoSalva, "codigo");
		return lancamentoSalva;
	}
	
	public void remover(long codigo) {
		this.lancamentoRepository.deleteById(codigo);
	}
}
