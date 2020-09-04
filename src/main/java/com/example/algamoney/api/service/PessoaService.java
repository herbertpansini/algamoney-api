package com.example.algamoney.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.algamoney.api.model.Pessoa;
import com.example.algamoney.api.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PessoaService {
	
	private final PessoaRepository pessoaRepository;
	
	public Pessoa buscarPessoaPeloCodigo(long codigo) {
		Pessoa pessoa = this.pessoaRepository.findById(codigo).orElse(null);
		if (pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa;
	}
	
	public Pessoa atualizar(long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = this.buscarPessoaPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return this.pessoaRepository.save(pessoaSalva);
	}
	
	public void atualizarPropriedadeAtivo(long codigo, boolean ativo) {
		Pessoa pessoaSalva = this.buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		this.pessoaRepository.save(pessoaSalva);
	}
}