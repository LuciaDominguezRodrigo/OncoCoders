export interface User {
  id: number;
  name: string;
  email: string;
  comunidadAutonoma: string;
  hospitalReferencia: string;
}

export interface UserDiagnosis {
  id: number;
  usuario: User;
  modelo1: string;
  modelo2: string;
  modelo3: string;
  modelo4: string;

}

