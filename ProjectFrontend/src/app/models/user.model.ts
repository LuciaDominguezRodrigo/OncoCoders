export interface User {
  name: string;
  email: string;
  role: string; // Puede ser 'admin', 'user', etc.
  token?: string; // Opcional, en caso de que el backend devuelva un token de autenticación
}
