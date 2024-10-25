

package dto;

import java.io.Serializable;

/**
 * Representa un cliente en el sistema
 * @author Saul Neri
 */
public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nombreCompleto;
    private String telefono;
    
    /**
     * Constructor sin argumentos que inicializa un nuevo objeto ClienteDTO.
     */
    public ClienteDTO() {

    }

    /**
     * Constructor que inicializa un nuevo objeto ClienteDTO con el ID
     * especificado.
     *
     * @param id el identificador único del cliente
     */
    public ClienteDTO(Long id) {
        this.id = id;
    }

    /**
     * Constructor que inicializa un nuevo objeto ClienteDTO con el teléfono
     * especificado.
     *
     * @param telefono el número de teléfono del cliente
     */
    public ClienteDTO(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el identificador único del cliente.
     *
     * @return el identificador del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador único del cliente.
     *
     * @param id el identificador del cliente a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del cliente.
     *
     * @return el nombre completo del cliente
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del cliente.
     *
     * @param nombreCompleto el nombre completo del cliente a establecer
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     *
     * @return el número de teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     *
     * @param telefono el número de teléfono del cliente a establecer
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteDTO)) {
            return false;
        }
        ClienteDTO other = (ClienteDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ClienteDTO[ id=" + id + " ]";
    }
}
