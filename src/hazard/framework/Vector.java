/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazard.framework;

/**
 *
 * @author jaiel
 */
public class Vector {
    public double x;
    public double y;
    
    public Vector(double x,double y){
        this.x=x;
        this.y=y;
    }
    
    public Vector plus(Vector vector){
        
        return new Vector(this.x+vector.x,this.y+vector.y);
    }
    public Vector plus(Vector vector, boolean affectThis){
        if(affectThis){
            this.x+=vector.x;
            this.y+=vector.y;
            return this;
        }
        return new Vector(this.x+vector.x,this.y+vector.y);
        
    }
    
    
    public Vector minus(Vector vector){
        return new Vector(this.x-vector.x,this.y-vector.y);
    }
    public Vector minus(Vector vector, boolean affectThis){
        if(affectThis){
            this.x-=vector.x;
            this.y-=vector.y;
            return this;
        }
        return new Vector(this.x+vector.x,this.y+vector.y);
        
    }
    
    public double getlength(){
        return Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y,2));
    }
    
    //Sets the x and y values to match the given lenght and keep the vector's direction;
    public Vector setlength(double l){ 
        this.times(l/this.getlength(), true);
        return this;
    }
    
    public Vector times(Vector value){
        return new Vector(this.x*value.x-this.y*value.y, this.x*value.y+this.y*value.x);
    }
    public Vector times(Vector value, boolean affectThis){
        if(affectThis){
            this.x=this.x*value.x-this.y*value.y;
            this.y=this.x*value.y+this.y*value.x;
            return this;
        }
        return new Vector(this.x*value.x-this.y*value.y, this.x*value.y+this.y*value.x);
        
    }
    
    
    public Vector times(double value){
        return new Vector(this.x*value,this.y*value);
    }
    public Vector times(double value, boolean affectThis){
        if(affectThis){
            this.x*=value;
            this.y*=value;
            return this;
        }
        return new Vector(this.x*value,this.y*value);
        
    }
    
    
    public Vector times(int value){
        return new Vector(this.x*value,this.y*value);
    }
    public Vector times(int value, boolean affectThis){
        if(affectThis){
            this.x*=value;
            this.y*=value;
            return this;
        }
        return new Vector(this.x*value,this.y*value);
        
    }
}
