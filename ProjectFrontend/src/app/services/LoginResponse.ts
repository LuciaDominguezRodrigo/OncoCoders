// src/app/services/auth.service.ts

export interface LoginResponse {
  user: {
    id: number;
    email: string;
    role: string;
  };
  token: string;
}
