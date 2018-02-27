package br.com.carlospantoja.notepadapi.service

import br.com.carlospantoja.notepadapi.model.Nota
import br.com.carlospantoja.notepadapi.repository.NotaRepository
import org.hibernate.validator.constraints.br.TituloEleitoral
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
        class NotaService{

    @Autowired
    lateinit var notaRepository: NotaRepository
    fun salvar(nota: Nota) {
        val aux = notaRepository.findByTitulo(nota.titulo)
        if (aux != null) {
            nota.id = aux.id
        }
        notaRepository.save(nota)
    }
    fun buscarTodas(): List<Nota> {
        return notaRepository.findAll()
    }
    fun buscar(titulo:String): Nota{
        return notaRepository.findByTitulo(titulo)
    }
}