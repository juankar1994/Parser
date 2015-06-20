/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.data;

/**
 *
 * @author JuanCarlos
 */
public class OperacionFactory {
    private IOperacion op;

    public OperacionFactory(String pOperation) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        setOp((IOperacion)Class.forName("parser.data."+pOperation).newInstance());
    }

    public IOperacion getOp() {
        return op;
    }

    public void setOp(IOperacion op) {
        this.op = op;
    }
    
    
    
}
