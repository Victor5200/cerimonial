import { Routes } from '@angular/router';

import { UserProfileComponent } from '../../pessoa/user-profile.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'cadastro-de-pessoa',   component: UserProfileComponent },
];
