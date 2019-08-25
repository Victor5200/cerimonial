import {Routes} from '@angular/router';

import {UserProfileComponent} from '../../pessoa/user-profile.component';
import {VocativoComponent} from '../../vocativo/vocativo.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'cadastro-de-pessoa',   component: UserProfileComponent },
    { path: 'vocativo',   component: VocativoComponent },
];
