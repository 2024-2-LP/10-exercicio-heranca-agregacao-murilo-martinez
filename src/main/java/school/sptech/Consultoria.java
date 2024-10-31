package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double salarios = 0.0;
        for(Desenvolvedor dev : desenvolvedores){
            salarios += dev.calcularSalario();
        }

        return salarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int qtdMobile = 0;

        for(int i = 0; i < desenvolvedores.size(); i++){
            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if(devDaVez instanceof DesenvolvedorMobile){
                qtdMobile++;
            }
        }

        return qtdMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devSalario = new ArrayList<>();

        for(Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() >= salario){
                devSalario.add(dev);
            }
        }

        return devSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor menorSalarioDev = desenvolvedores.get(0);

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario() < menorSalarioDev.calcularSalario()) {
                menorSalarioDev = dev;
            }
        }
        return menorSalarioDev;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        if(desenvolvedores.isEmpty()){
            return null;
        }

        List<Desenvolvedor> devsPorTec = new ArrayList<>();

        for(var i = 0; i < desenvolvedores.size(); i++){
            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if(devDaVez instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) devDaVez).getFrontend().contains(tecnologia)){
                    devsPorTec.add(devDaVez);
                }
                if(((DesenvolvedorWeb) devDaVez).getBackend().contains(tecnologia)){
                    devsPorTec.add(devDaVez);
                }
                if(((DesenvolvedorWeb) devDaVez).getSgbd().contains(tecnologia)){
                    devsPorTec.add(devDaVez);
                }
            }

            if(devDaVez instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) devDaVez).getPlataforma().contains(tecnologia)){
                    devsPorTec.add(devDaVez);
                }

                if(((DesenvolvedorMobile) devDaVez).getLinguagem().contains(tecnologia)){
                    devsPorTec.add(devDaVez);
                }
            }
        }

        return devsPorTec;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salarios = 0.0;

        for(var i = 0; i < desenvolvedores.size(); i++){
            Desenvolvedor devDaVez = desenvolvedores.get(i);

            if(devDaVez instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) devDaVez).getFrontend().contains(tecnologia)){
                    salarios += devDaVez.calcularSalario();
                }
                if(((DesenvolvedorWeb) devDaVez).getBackend().contains(tecnologia)){
                    salarios += devDaVez.calcularSalario();
                }
                if(((DesenvolvedorWeb) devDaVez).getSgbd().contains(tecnologia)){
                    salarios += devDaVez.calcularSalario();
                }
            }

            if(devDaVez instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) devDaVez).getPlataforma().contains(tecnologia)){
                    salarios += devDaVez.calcularSalario();
                }

                if(((DesenvolvedorMobile) devDaVez).getLinguagem().contains(tecnologia)){
                    salarios += devDaVez.calcularSalario();
                }
            }
        }

        return salarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }
}
