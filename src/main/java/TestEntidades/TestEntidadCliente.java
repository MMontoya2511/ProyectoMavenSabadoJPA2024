package TestEntidades;

import java.util.List;

import Dao.ClassClienteImp;
import model.TblCliente;

public class TestEntidadCliente {

	public static void main(String[] args) {
		//realizar la respectiva instancia de las clases
		TblCliente cliente=new TblCliente();
		ClassClienteImp crud=new ClassClienteImp();
		
	/*	//asignamos valores
		cliente.setNombre("nilson ronaldo");
		cliente.setApellido("ramirez ramirez");
		cliente.setDni("1045789");
		cliente.setEmail("nilson@gmail.com");
		cliente.setTelf("997709474");
		cliente.setSexo("M");
		cliente.setNacionalidad("argentina");
		
		//invocamos al metodo REGISTRAR
		crud.RegistrarCliente(cliente); */
		
		//test del metodo Listado
		List<TblCliente> listado = crud.ListadoCliente();
		
		//aplicamos un bucle for...
		for(TblCliente lis:listado){
			
			//imprimimos por pantalla
			System.out.println("nombre "+lis.getNombre()+
	                   " apellido "+lis.getApellido()+
	                   " dni "+lis.getDni()+
	                   " email "+lis.getEmail()+
	                   " telef "+lis.getTelf()+
	                   " sexo "+lis.getSexo()+
	                   " nacionalidad "+lis.getNacionalidad());			
		}

	} //fin del metodo 

}//fin de la clase
