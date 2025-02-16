export type UserRole = "PUBLIC" | "USER" | "MEDICUSER" | "ADMIN" | "RESEARCHERUSER";

export function convertToUserRole(role: string): UserRole {
  const validRoles: UserRole[] = ["USER", "MEDICUSER", "ADMIN", "RESEARCHERUSER"];

  return validRoles.includes(role as UserRole) ? (role as UserRole) : "PUBLIC";
}

